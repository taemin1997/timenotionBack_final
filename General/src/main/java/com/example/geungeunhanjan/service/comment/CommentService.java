package com.example.geungeunhanjan.service.comment;

import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentWriteDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Slice;

import java.util.List;

public interface CommentService {
    // 1. 댓글 작성
    void registComment(CommentWriteDTO commentWriteDTO);

    // 2. 댓글 목록 불러오기
    List<CommentListDTO> findCommentList(Long boardId);

    // 3. 댓글 페이징 !
    Slice<CommentListDTO> findCommentSlice (Criteria criteria, Long boardId);

    // 4. 댓글 삭제
    void removeComment(Long commentId);


}
