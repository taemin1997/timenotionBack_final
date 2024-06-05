package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {

    // 메인 페이지
    @GetMapping()
    public String admin() {
        return "/admin/mdj/adminDashBoard";
    }

    // 게시판 관리
    @GetMapping("/boardList")
    public String boardList() {
        return "/admin/dam/admin-board-list";
    }

    // 회원 관리
    @GetMapping("/memberList")
    public String MemberList() {
        return "/admin/dam/admin-member-list";
    }

    // 신고 관리
    @GetMapping("/reportList")
    public String reportList() {
        return "/admin/dam/admin-report-list";
    }

    // 공지사항 관리
    @GetMapping("/noticeList")
    public String noticeList() {
        return "/admin/dam/admin-notice-list";
    }

    // 1:1 문의
    @GetMapping("/inquiryList")
    public String inquiryList() {
        return "/admin/dam/admin-inquiry-list";
    }
}