package com.sparta.week01hw.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {

  private String title;
  private String username;
  private String contents;

}
