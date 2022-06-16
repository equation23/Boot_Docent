package com.docent.dsel.repository;



import com.docent.dsel.entity.Board;
import com.docent.dsel.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

}
