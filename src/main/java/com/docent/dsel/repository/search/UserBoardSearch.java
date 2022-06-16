package com.docent.dsel.repository.search;

import com.docent.dsel.entity.UserBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserBoardSearch {
    Page<UserBoard> userBoardSearchAll(String[] types, String keyword, Pageable pageable);
}
