package com.docent.dsel.service;

import com.docent.dsel.entity.UserBoard;
import com.docent.dsel.dto.PageRequestDTO;
import com.docent.dsel.dto.PageResponseDTO;
import com.docent.dsel.dto.UserBoardDTO;
import com.docent.dsel.repository.UserBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class UserBoardServiceImpl implements UserBoardService{
    private final ModelMapper modelMapper;
    private final UserBoardRepository userBoardRepository;

    @Override
    public Long register(UserBoardDTO userBoardDTO) {
//        UserBoard userBoard = modelMapper.map(userBoardDTO ,UserBoard.class);
        UserBoard userBoard = dtoToEntity(userBoardDTO);
        UserBoard result = userBoardRepository.save(userBoard);
        log.info("----------------------------");
        log.info(userBoard);
        log.info(userBoard.getImgSet());
        return result.getUbno();
    }

    @Override
    public UserBoardDTO readOne(Long ubno) {

        Optional<UserBoard> result = userBoardRepository.findById(ubno);

        UserBoard userBoard = result.orElseThrow();

        UserBoardDTO userBoardDTO = modelMapper.map(userBoard, UserBoardDTO.class);

        return userBoardDTO;
    }

    @Override
    public PageResponseDTO<UserBoardDTO> list (PageRequestDTO pageRequestDTO) {

        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getDescPageable("ubno");

        Page<UserBoard> result = userBoardRepository.userBoardSearchAll(types, keyword, pageable);

        List<UserBoardDTO> dtoList = result.getContent().stream()
                .map(userBoard -> modelMapper.map(userBoard,UserBoardDTO.class)).collect(Collectors.toList());


        return PageResponseDTO.<UserBoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();

    }

}
