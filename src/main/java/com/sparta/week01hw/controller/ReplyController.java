package com.sparta.week01hw.controller;


import com.sparta.week01hw.domain.Reply;
import com.sparta.week01hw.domain.ReplyRepository;
import com.sparta.week01hw.domain.ReplyRequestDto;
import com.sparta.week01hw.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyController {

  private final ReplyService replyService;

  @PostMapping("/api/replys")
  public String ceateReply(@RequestBody ReplyRequestDto requestDto) {
    if(requestDto.getContents().equals("")){
      return "댓글 내용을 입력해주세요";
    }
    Reply reply = new Reply(requestDto);
    replyService.writeReply(reply);
    return "댓글 작성 성공";
  }

  @GetMapping("/api/replys/{boardId}")
  public List<Reply> getReply(@PathVariable Long boardId) {
    return replyService.getReplys(boardId);
  }


  @PutMapping("/api/replys/{id}")
  public String updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto) {
    if(requestDto.getContents().equals("")){ //.equals 문자열 비교할 때 숫자일 때는 == 가능
      return "댓글 내용을 입력해주세요";
    }
    replyService.update(id,requestDto);
      return "댓글 수정 성공";
  }

  @DeleteMapping("/api/replys/{id}")
  public String deleteReply(@PathVariable Long id) {
    replyService.delete(id);
    return String.format("댓글 %s 삭제 완료",id);
  }
}
