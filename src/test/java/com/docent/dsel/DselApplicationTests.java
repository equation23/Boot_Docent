package com.docent.dsel;

import com.docent.dsel.dto.PageRequestDTO;
import com.docent.dsel.dto.UserBoardDTO;
import com.docent.dsel.entity.UserBoard;
import com.docent.dsel.repository.UserBoardRepository;
import com.docent.dsel.service.UserBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@Log4j2
@RequiredArgsConstructor
@SpringBootTest
class DselApplicationTests {

    @Autowired
    private UserBoardService userBoardService;
    @Autowired
    private UserBoardRepository userBoardRepository;


    @Test
    void makeBoardList() {
//        UserBoardDTO userBoardDTO = UserBoardDTO.builder()
//                .did("user02")
//                .nickName("GTM2")
//                .content("TEST2")
//                .title("입력테스트2")
//                .build();
        for (int i = 0; i < 210; i++) {


            UserBoard userBoard = UserBoard.builder()
                    .did("user" + i)
                    .nickName("GTM" + i)
                    .content("TEST" + i)
                    .title("입력테스트" + i)
                    .build();
            userBoardRepository.save(userBoard);
        }
    }

    @Test
    public void getList() {

    }
}