package com.docent.dsel.repository.search;

import com.docent.dsel.entity.Board;
import com.docent.dsel.entity.QUserBoard;
import com.docent.dsel.entity.UserBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class UserBoardSearchImpl extends QuerydslRepositorySupport implements UserBoardSearch{


    public UserBoardSearchImpl(){
        super(UserBoard.class);
    }

    @Override
    public Page<UserBoard> userBoardSearchAll(String[] types, String keyword, Pageable pageable) {
        QUserBoard userBoard = QUserBoard.userBoard;
        JPQLQuery<UserBoard> query = from(userBoard);

        if( (types != null && types.length > 0) && keyword != null ){ //검색 조건과 키워드가 있다면

            BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

            for(String type: types){

                switch (type){
                    case "t":
                        booleanBuilder.or(userBoard.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(userBoard.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(userBoard.nickName.contains(keyword));
                        break;
                }
            }//end for
            query.where(booleanBuilder);
        }//end if

        //bno > 0
        query.where(userBoard.ubno.gt(0L));

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<UserBoard> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);

    }
}
