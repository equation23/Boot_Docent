package com.docent.dsel.service;

import com.docent.dsel.dto.BoardDTO;
import com.docent.dsel.dto.ListResponseDTO;
import com.docent.dsel.dto.PageRequestDTO;
import com.docent.dsel.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {


        BoardDTO readOne(Long bno);

        PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

        ListResponseDTO<BoardDTO> readAll(PageRequestDTO pageRequestDTO);
}
