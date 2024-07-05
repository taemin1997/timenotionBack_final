package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.comment.CommentListDTO;
import com.example.geungeunhanjan.domain.vo.board.ReportVO;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.admin.admin_reportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ReportApi {
    private final MyPageService myPageService;
    private final CommentListDTO commentListDTO;
    private final admin_reportService adminReportService;



    /* 신고 등록 */
    @PostMapping("/v1/submitReport")
    @Transactional
    public  Map<String, Object> registReport(@RequestParam Long commentId,
                                                @RequestParam Long userId,
                                                @RequestParam String reportReason) {
        // 신고사유가 서버에서 오면서 콤마들어가서 지워줌
        reportReason = reportReason.replace(",", "").trim();
        // 넘겨받은 값 세팅
        ReportVO reportVO = new ReportVO();
        reportVO.setCommentId(commentId);
        reportVO.setUserId(userId);
        reportVO.setReportReason(reportReason);


        // 확인
        Map<String, Object> response  = new HashMap<>();
        try {
            System.out.println("전달받은 신고 VO ------------- " + reportVO);
            response.put("success", true);
            response.put("message", "신고가 성공적으로 등록되었습니다.");
            myPageService.insertReport(reportVO);
        } catch (Exception e){
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "신고 등록 중 오류가 발생했습니다.");
        }
        return response;
    }



/*
    @DeleteMapping("/report/delete/{commentId}")
    public String deleteReport(@PathVariable Long commentId){
        adminReportService.managementReport(commentId);
        return "redirect:/"
    }
*/


} // 괄호



/*
@PathVariable Long boardId*/
