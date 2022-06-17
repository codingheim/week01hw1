package com.sparta.week01hw.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
public class Reply extends Timestamped {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(nullable = false)
  private Long boardId;


  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String contents;

  public Reply(Long boardId, String username, String contents) {
    this.boardId = boardId;
    this.username = username;
    this.contents = contents;
  }

  public Reply(ReplyRequestDto requestDto) {
    this.boardId = requestDto.getBoardId();
    this.username = requestDto.getUsername();
    this.contents = requestDto.getContents();
  }

  public void update(ReplyRequestDto requestDto) {
    this.boardId = requestDto.getBoardId();
    this.username = requestDto.getUsername();
    this.contents = requestDto.getContents();
  }
}
