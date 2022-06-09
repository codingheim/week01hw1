package com.sparta.week01hw.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
  List<Board> findAllByOrderByModifiedAtDesc(); //최신순으로 정렬
}



