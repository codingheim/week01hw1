package com.sparta.week01hw.service;


import com.sparta.week01hw.domain.Board;
import com.sparta.week01hw.domain.BoardRepository;
import com.sparta.week01hw.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional //SQL 쿼리의 반응을 스프링에게 알려줌
  public Long update(Long id, BoardRequestDto requestDto) {
    Board board = boardRepository.findById(id).orElseThrow(
            () -> new NullPointerException("존재하지 않는 게시물입니다.")
    );
    board.update(requestDto);
    return board.getId();
  }
}
