package com.docent.dsel.repository;

import com.docent.dsel.entity.UserBoard;
import com.docent.dsel.repository.search.BoardSearch;
import com.docent.dsel.repository.search.UserBoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserBoardRepository extends JpaRepository<UserBoard,Long>, UserBoardSearch {
    @EntityGraph(attributePaths = "imgSet")
    @Query("select b from UserBoard b where b.ubno = :ubno")
    Optional<UserBoard> getWithImage(Long ubno);

}
