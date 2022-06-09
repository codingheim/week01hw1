package com.sparta.week01hw.service;

import com.sparta.week01hw.domain.Reply;
import com.sparta.week01hw.domain.ReplyRepository;
import com.sparta.week01hw.domain.ReplyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

  private final ReplyRepository replyRepository;

  public List<Reply> getReplys(Long boardId) {
    return replyRepository.findAllByBoardIdOrderByModifiedAtDesc(boardId);
  }

  public void writeReply(Reply reply) {
    replyRepository.save(reply);
  }

  @Transactional
  public Long update(Long id, ReplyRequestDto requestDto) {
    Reply reply = replyRepository.findById(id).orElseThrow(
            () -> new NullPointerException("해당 댓글이 존재하지 않습니다.")
    );
    reply.update(requestDto);
    return reply.getId();
  }

  public void delete(Long id) {
    replyRepository.deleteById(id);
  }
}
