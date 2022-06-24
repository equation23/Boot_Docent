package com.docent.dsel.controller;

import com.docent.dsel.dto.BoardDTO;
import com.docent.dsel.dto.PageRequestDTO;
import com.docent.dsel.dto.PageResponseDTO;
import com.docent.dsel.dto.UserBoardDTO;
import com.docent.dsel.service.BoardService;
import com.docent.dsel.service.UserBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/docent")
public class BoardController {
    private final BoardService boardService;
    private final UserBoardService userboardService;

    //리스트 페이지
    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    //유적,명소 read페이지
    @GetMapping("/read")
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model) {

        BoardDTO boardDTO = boardService.readOne(bno);

        model.addAttribute("dto", boardDTO);

    }
    //사용자 게시판
    @GetMapping("/userBoard")
    public void getUserBoard(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<UserBoardDTO> responseDTO = userboardService.list(pageRequestDTO);

        model.addAttribute("responseDTO", responseDTO);
    }
    //사용자 게시판 read 페이지
    @GetMapping("/userBoardRead")

    public void getUserBoardRead(Long bno, PageRequestDTO pageRequestDTO, Model model) {

        UserBoardDTO userBoardDTO = userboardService.readOne(bno);

        model.addAttribute("dto", userBoardDTO);

    }
    @GetMapping("/boardRegister")
    public void getUserBoardRegister(PageRequestDTO pageRequestDTO) {

    }
}
