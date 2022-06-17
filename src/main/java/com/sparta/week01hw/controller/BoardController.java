package com.sparta.week01hw.controller;


import com.sparta.week01hw.domain.*;
import com.sparta.week01hw.service.BoardService;
import com.sparta.week01hw.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

  private final BoardRepository boardRepository;
  private final BoardService boardService;


  @PostMapping("/api/boards")
  public Board createBoard(@RequestBody BoardRequestDto requestDto) {
    Board board = new Board(requestDto); //생성자
    return boardRepository.save(board);
  }

  @GetMapping("/api/boards")
  public List<Board> getBoards() {
    return boardRepository.findAllByOrderByModifiedAtDesc();
  }

  @GetMapping("/api/boards/{id}")
  public Board getBoard(@PathVariable Long id) {
    return boardRepository.findById(id).orElseThrow(
            () -> new NullPointerException("해당 게시물이 존재하지 않습니다.")
    );
  }

  @PutMapping("/api/boards/{id}")
  public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
    boardService.update(id, requestDto);
    return id;
  }

  @DeleteMapping("/api/boards/{id}")
  public Long deleteBoard(@PathVariable Long id) {
    boardRepository.deleteById(id);
    return id;
  }
}
