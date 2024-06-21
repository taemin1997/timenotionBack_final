package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentWriteDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Slice;
import com.example.geungeunhanjan.service.comment.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;
    /* 여기 댓글 서비스 넣어야함 */

    // 1. 댓글 작성
    @PostMapping("/v1/boards/{boardId}/reply")
    public void commentWrite(@RequestBody CommentWriteDTO commentWriteDTO,
                             @PathVariable("boardId") Long boardId,
                             HttpServletRequest request){
        /* 요청 본문에서 ReplyWriteDTO 받아오고, url 경로에서 boardId를 추출하여 boardId 파라미터에 바인딩
         *  세션에서 userId 받아줌 */
        Long uniId = (Long) request.getSession().getAttribute("uniId");
        System.out.println(uniId);
        commentWriteDTO.setBoardId(boardId);
        commentWriteDTO.setUserId(uniId);

        System.out.println("boardID : " + boardId + " uniId : " + uniId);

        commentService.registComment(commentWriteDTO);
    }
    // 2. 댓글 목록 뿌리기
    @GetMapping("/v1/boards/{boardId}/replies")
    public List<CommentListDTO> commentList(@PathVariable("boardId") Long boardId){
        return commentService.findCommentList(boardId);
    }
    // 3. Slice
    @GetMapping("/v2/boards/{boardId}/replies")
    public Slice<CommentListDTO> commentListSlice(@PathVariable("boardId") Long boardId,
                                                  int page){
        Criteria criteria = new Criteria(page, 10);
        Slice<CommentListDTO> slice =
                commentService.findCommentSlice(criteria, boardId);
        return slice;
    }
    // 4. 댓글 삭제
    @DeleteMapping("/v1/replies/{commentId}")
    public void removeComment(@PathVariable("commentId") Long commentId){
        commentService.removeComment(commentId);
    }


    // 5. 댓글 수정
    /* @PatchMapping()*/


}
