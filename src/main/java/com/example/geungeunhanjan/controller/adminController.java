package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserInfoDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.admin.admin_boardListService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class adminController {

    private final admin_boardListService adminBoardListService;

    // 메인 페이지
    @GetMapping()
    public String admin() {
        return "/admin/mdj/adminDashBoard";
    }

    // 게시판 관리
    @GetMapping("/boardList")
    public String boardList(Model model, HttpSession session, Criteria criteria,
                            @RequestParam(required = false, defaultValue = "latest") String sort) {


        // 페이징 처리를 위한 코드
        criteria.setAmount(12);
        List<BoardDTO> adminBoardLists = adminBoardListService.everyLifeFindPage(criteria);

        int total = adminBoardListService.everyLifeFindTotal();
        Page page = new Page(criteria, total);
        model.addAttribute("adminBoardLists", adminBoardLists); // 실제로 가져온 게시물 리스트를 모델에 추가
        model.addAttribute("page", page);
        model.addAttribute("sort", sort);

        return "admin/dam/admin-board-list"; // 페이지 이름 반환
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

    // 관리자 디테일
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long boardId) {
        BoardVO board = adminBoardListService.everyLifeDetail(boardId);
        model.addAttribute("board", board);

        return "/admin/admin_tm/admin_detail";
    }
}