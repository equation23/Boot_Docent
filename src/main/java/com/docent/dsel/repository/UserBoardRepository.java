package com.docent.dsel.repository;

import com.docent.dsel.entity.UserBoard;
import com.docent.dsel.repository.search.BoardSearch;
import com.docent.dsel.repository.search.UserBoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserBoardRepository extends JpaRepository<UserBoard,Long>, UserBoardSearch {
}
