package com.example.geungeunhanjan.service.comment;

import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentWriteDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Slice;
import com.example.geungeunhanjan.mapper.comment.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

   private final CommentMapper commentMapper;
    // 1. 댓글 작성
    @Override
    public void registComment(CommentWriteDTO commentWriteDTO) {
        commentMapper.insertComment(commentWriteDTO);
    }
    // 2. 댓글 목록 불러오기
    @Override
    public List<CommentListDTO> findCommentList(Long boardId) {;
        return commentMapper.selectCommentList(boardId);
    }

    // 3. 댓글 페이징 !
    @Override
    public Slice<CommentListDTO> findCommentSlice(Criteria criteria, Long boardId) {
        List<CommentListDTO> commentList =
                commentMapper.selectCommentSlice(criteria, boardId);
        boolean hasNext = commentList.size() > criteria.getAmount();
        if (hasNext) {
            commentList.remove(criteria.getAmount());
        }
        return new Slice<>(hasNext, commentList);
    }

    // 4. 댓글 삭제
    @Override
    public void removeComment(Long commentId) {
        commentMapper.deleteComment(commentId);
    }



}
