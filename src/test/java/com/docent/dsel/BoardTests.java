package com.docent.dsel;

import com.docent.dsel.entity.UserBoard;
import com.docent.dsel.repository.UserBoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
@SpringBootTest
@Log4j2
public class BoardTests {
    @Autowired
    private UserBoardRepository userBoardRepository;
    @Test
    public void testInsertWithImage() {

        for (int i = 0; i < 10;i++){

            UserBoard board = UserBoard.builder()
                    .title("Image Test..")
                    .content("content..." )
                    .did("user11")
                    .nickName("GTM564")
                    .build();

            //일부 게시물은 첨부파일이 없는 경우도 있도록
            if(i % 10 != 0) {
                board.addImage(UUID.randomUUID().toString() + "_aaa.jpg");
                board.addImage(UUID.randomUUID().toString() + "_bbb.jpg");
            }
            UserBoard result = userBoardRepository.save(board);
            log.info("BNO: " + result.getUbno());

        }//end for
    }

    @Test
    public void testReadWithImage() {

        //실제 첨부가 있는 번호를 테스트
        Optional<UserBoard> result = userBoardRepository.getWithImage(223L);

        UserBoard board = result.orElseThrow();

        log.info(board);

        log.info(board.getImgSet());

    }
}
