package com.docent.dsel.repository.search;

import com.docent.dsel.entity.Board;
import com.docent.dsel.entity.UserBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardSearch {

    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);



}
