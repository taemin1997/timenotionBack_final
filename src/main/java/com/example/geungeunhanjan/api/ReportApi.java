package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.vo.board.ReportVO;
import com.example.geungeunhanjan.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReportApi {
    public final MyPageService myPageService;
    private final CommentListDTO commentListDTO;


    /* 신고 등록 */
    @PostMapping("/v1/{boardId}/submitReport")
    @Transactional
    public ResponseEntity<String> registReport(
            @PathVariable Long boardId,
            @RequestParam Long commentId,
            @RequestParam Long userId,
            @RequestParam String reportReason) {

        ReportVO reportVO = new ReportVO();
        reportVO.setCommentId(commentId);
        reportVO.setUserId(userId);
        reportVO.setReportReason(reportReason);

        try {
            myPageService.insertReport(reportVO);
            return ResponseEntity.ok("신고가 성공적으로 등록되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("신고 등록 중 오류가 발생했습니다.");
        }
    }
}
