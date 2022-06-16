package com.docent.dsel.service;


import com.docent.dsel.dto.PageRequestDTO;
import com.docent.dsel.dto.PageResponseDTO;
import com.docent.dsel.dto.UserBoardDTO;


public interface UserBoardService {
    Long register(UserBoardDTO userBoardDTO);

    UserBoardDTO readOne(Long ubno);

    PageResponseDTO<UserBoardDTO> list(PageRequestDTO pageRequestDTO);


}
