package com.example.geungeunhanjan.mapper.comment;

import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentWriteDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Slice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 1. 댓글 작성
    void insertComment(CommentWriteDTO commentWriteDTO);

    // 2. 댓글 목록 불러오기
    List<CommentListDTO> selectCommentList(Long boardId);

    // 3. 댓글 페이징 !
//    Slice<CommentListDTO> selectCommentSlice (@Param("criteria") Criteria criteria, @Param("boardId")Long boardId);
    List<CommentListDTO> selectCommentSlice (@Param("criteria") Criteria criteria, @Param("boardId")Long boardId);

    // 4. 댓글 삭제
    void deleteComment(Long commentId);



}
