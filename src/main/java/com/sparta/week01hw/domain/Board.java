package com.sparta.week01hw.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//class는 뭐하는 녀석인가
//JPA를 위한 테이블 생성 그에 필요한 어노테이션
@NoArgsConstructor //기본생성자
@Getter
@Entity //테이블 연결을 위한 어노테이션
public class Board extends Timestamped {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id //기본키를 나타냄.
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String contents;

public Board(String title, String username, String contents) {
  this.title = title;
  this.username = username;
  this.contents = contents;
}

public Board(BoardRequestDto requestDto) {
  this.title = requestDto.getTitle();
  this.username = requestDto.getUsername();
  this.contents = requestDto.getContents();
}
public void update(BoardRequestDto requestDto) {
  this.title = requestDto.getTitle();
  this.username = requestDto.getUsername();
  this.contents = requestDto.getContents();
}
}
