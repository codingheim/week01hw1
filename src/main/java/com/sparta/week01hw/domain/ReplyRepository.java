package com.sparta.week01hw.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
  List<Reply> findAllByBoardIdOrderByModifiedAtDesc(Long boardId);
}
