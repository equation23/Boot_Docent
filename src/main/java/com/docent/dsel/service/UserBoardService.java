package com.docent.dsel.service;


import com.docent.dsel.dto.PageRequestDTO;
import com.docent.dsel.dto.PageResponseDTO;
import com.docent.dsel.dto.UserBoardDTO;
import com.docent.dsel.entity.UserBoard;

import java.util.stream.Collectors;


public interface UserBoardService {
    Long register(UserBoardDTO userBoardDTO);

    UserBoardDTO readOne(Long ubno);

    PageResponseDTO<UserBoardDTO> list(PageRequestDTO pageRequestDTO);

    default UserBoard dtoToEntity(UserBoardDTO userBoardDTO){

        UserBoard userBoard = UserBoard.builder()
                .ubno(userBoardDTO.getUbno())
                .title(userBoardDTO.getTitle())
                .content(userBoardDTO.getContent())
                .did(userBoardDTO.getDid())
                .nickName(userBoardDTO.getNickName())

                .build();

        if(userBoardDTO.getFileList() != null && userBoardDTO.getFileList().size() > 0) {
            userBoardDTO.getFileList().forEach(imgLink -> userBoard.addImage(imgLink));
        }

        return userBoard;
    }

    default UserBoardDTO entityToDto(UserBoard userBoard) {

        UserBoardDTO dto = UserBoardDTO.builder()
                .ubno(userBoard.getUbno())
                .title(userBoard.getTitle())
                .content(userBoard.getContent())
                .did(userBoard.getDid())
                .nickName(userBoard.getNickName())
                .regDate(userBoard.getRegDate())
                .updateDate(userBoard.getUpdateDate())
                .build();

        if(userBoard.getImgSet() != null && userBoard.getImgSet().size() > 0) {
            dto.setFileList(
                    userBoard.getImgSet().stream().map(userBoardImage -> userBoardImage.getFileLink())
                            .collect(Collectors.toList()));
        }

        return dto;
    }

}
