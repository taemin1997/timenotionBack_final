package com.example.geungeunhanjan.controller.lifes;

import com.example.geungeunhanjan.domain.vo.board.ReportVO;
import com.example.geungeunhanjan.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {
    private final MyPageService myPageService;

    /* 신고 작성 */

/*
    @PostMapping("/submitReport")
    public void submitReport(@ModelAttribute ReportVO reportVO) {
        myPageService.insertReport(reportVO);

        System.out.println("신고신고");
        System.out.println("신고 : ==================================" + reportVO);
    }
*/




}
