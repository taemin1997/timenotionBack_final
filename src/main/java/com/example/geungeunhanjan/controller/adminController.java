package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.NoticePage.NoticePage;
import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserInfoDTO;
import com.example.geungeunhanjan.domain.dto.board.ReportListDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.community.MemberDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryPage;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.admin.*;
import com.example.geungeunhanjan.service.community.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class adminController {

    private final admin_boardListService adminBoardListService;
    private final admin_dashBoardService adminDashBoardService;
    private final admin_inquiryService adminInquiryService;
    private final NoticeService noticeService;
    private final admin_noticeListService adminNoticeListService;
    private final admin_memberListService adminMemberListService;
    private final MyPageService myPageService;
    private final admin_reportService adminReportService;
    BoardVO boardVO;

    // 메인 페이지
    @GetMapping()
    public String admin(Model model) {
        int totalMembers = adminDashBoardService.getTotalMemberCount();
        Date today = adminDashBoardService.getTodayDate();
        int countReport = adminDashBoardService.countReportsToday();
        int countInquiry = adminDashBoardService.countInquiryToday();
        model.addAttribute("totalMembers", totalMembers);
        model.addAttribute("today", today);
        model.addAttribute("countReport", countReport);
        model.addAttribute("countInquiry", countInquiry);

        return "/admin/mdj/adminDashBoard";
    }

    // 게시판 관리
    @GetMapping("/boardList")
    public String boardList(Model model,
                            Criteria criteria,
                            HttpServletRequest request,
                            @RequestParam(required = false, defaultValue = "latest") String sort,
                            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
        // 검색어가 있을 경우 Criteria에 검색어 설정
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            criteria.setKeyword(searchKeyword);
        } else {
            criteria.setKeyword(null);
        }

        // 페이징 및 검색 기능 처리
        List<BoardDTO> adminBoardLists = adminBoardListService.everyLifeFindPage(criteria);

        int total = adminBoardListService.everyLifeFindTotal();
        Page page = new Page(criteria, total);
        model.addAttribute("adminBoardLists", adminBoardLists); // 실제로 가져온 게시물 리스트를 모델에 추가
        model.addAttribute("page", page);
        model.addAttribute("sort", sort);
        model.addAttribute("searchKeyword", searchKeyword);

        return "admin/dam/admin-board-list"; // 페이지 이름 반환
    }


    //게시글 삭제시
    @PostMapping("/boardList/{boardId}")
    public String boardList( @PathVariable("boardId") long boardId){
        adminBoardListService.removeBoard(boardId);
        return "redirect:/admin/boardList";
    }

    // 관리자 디테일
    @GetMapping("/detail")
    public String detail(Model model, Long boardId, HttpSession session) {
        Long uniId = (Long)session.getAttribute("uniId");
        if (uniId == null) {
            return "redirect:/user/login";
        }
        BoardVO boards = adminBoardListService.selectById(boardId);
        adminBoardListService.boardIntViewCnt(boardId);
        String userNickname = adminBoardListService.boardUserName(boardId);
        // 유저 정보 모두
        LifeUserInfoDTO userInfo = myPageService.selectAllInfo(uniId);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("boards", boards);
        model.addAttribute("userNickname", userNickname);

        return "admin/admin_tm/admin_detail";
    }

    // 게시글 수정
    @GetMapping("/update")
    public String update(Long boardId, Model model) {
        BoardVO boards = adminBoardListService.selectById(boardId);
        model.addAttribute("boards",boards);

        return "admin/admin_tm/admin_update";
    }

    // 게시글 수정
    @PostMapping("/update")
    public String update(BoardVO boardVO, @RequestParam("boardFile") List<MultipartFile> files, RedirectAttributes redirectAttributes){
        try{
            adminBoardListService.modifyBoard(boardVO, files);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        redirectAttributes.addAttribute("boardId", boardVO.getBoardId());
        return "redirect:/admin/boardList";
    }

    //게시글 삭제
    @GetMapping("/remove")
    public RedirectView removeBoard(Long boardId, Long likeId){
        adminBoardListService.removeLike(likeId);
        adminBoardListService.removeBoard(boardId);
        return new RedirectView("/admin/boardList");
    }

    // 회원 관리
    @GetMapping("/memberList")
    public String MemberList(Model model,
                             NoticeCriteria noticeCriteria,
                             HttpServletRequest request,
                             @RequestParam(value = "searchKeyword" , required = false) String searchKeyword) {

        List<MemberDTO> memberLists;
        int total;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("keyword", searchKeyword);
        paramMap.put("page", noticeCriteria.getPage());
        paramMap.put("amount", noticeCriteria.getAmount());



        //검색 기능 추가
        if(searchKeyword != null && !searchKeyword.isEmpty()) {
            //검색어가 있는경우 검색 결과를 가져옴
            memberLists = adminMemberListService.adminSelectMember(paramMap);
            System.out.println("memberLists = " + memberLists);
            total = adminMemberListService.countSearchKeyword(searchKeyword);
            System.out.println("검색 단어 포함 total = " + total);
        }else{
            //검색어가 없는 경우 모든 공지사항을 가져옴
            memberLists = adminMemberListService.selectAllPageMember(noticeCriteria);
            System.out.println("memberLists = " + memberLists);
            total = adminMemberListService.selectTotalMember();
        }
        //페이지 처리
        NoticePage noticePage = new NoticePage(noticeCriteria, total);
        System.out.println("noticePage = " + noticePage);

        //페이징 정보 가져오기
        model.addAttribute("memberLists", memberLists);
        model.addAttribute("page", noticePage);
        model.addAttribute("searchKeyword", searchKeyword);

        return "/admin/dam/admin-member-list";
    }


    @PostMapping("/memberList")
    @ResponseBody // JSON 응답을 위한 어노테이션
    public ResponseEntity<String> memberList(
            @RequestParam("statusStep") int statusStep,
            @RequestParam("uniId") Long uniId) {

        try {
            // 각 상태에 따라 서비스 호출
            switch (statusStep) {
                case 1:
                    adminMemberListService.updateStatusGeneral(uniId);
                    break;
                case 2:
                    adminMemberListService.updateStatusSuspension(uniId);
                    break;
                case 3:
                    adminMemberListService.updateStatuswithdrawal(uniId);
                    break;
            }

            // 리다이렉트 URL 반환
            // 여기서 리다이렉트 URL은 클라이언트 측에서 처리하므로 ResponseEntity로 JSON 응답을 반환합니다.
            return ResponseEntity.ok().body("{\"redirectUrl\": \"/admin/memberList\"}");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"서버 오류\"}");
        }
    }


    // 신고 관리
    @GetMapping("/reportList")
    public String reportList(Model model, Criteria criteria) {
        criteria.setAmount(10); // 한 페이지에 몇 개 보일지 설정

        List<ReportListDTO> reports = adminReportService.reportPagingList(criteria);
        int total = adminReportService.reportTotalCount();
        Page page = new Page(criteria, total);


        model.addAttribute("reports", reports);
        model.addAttribute("page", page);



        return "/admin/dam/admin-report-list";
    }
    // 신고 삭제 컨트롤러
    @PostMapping("/reportdelete/{commentId}")
    public String deleteReport(@PathVariable Long commentId){
        adminReportService.managementReport(commentId);
        System.out.println("관리지ㅏ 신고관리 commentId :" +  commentId);
        System.out.println("댓글 신고 삭제 컨트롤러 호출됨");
        return "redirect:/reportList";
    }

    // 공지사항 관리

    @GetMapping("/noticeList")
    public String noticeList(Model model,
                             NoticeCriteria noticeCriteria,
                             @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
        List<NoticePageDTO> noticeLists;
        int total;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("keyword", searchKeyword);
        paramMap.put("page", noticeCriteria.getPage());
        paramMap.put("amount", noticeCriteria.getAmount());

        // 검색 기능 추가
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            // 검색어가 있는 경우 검색 결과를 가져옴
            noticeLists = adminNoticeListService.adminSelectNotice(paramMap);
            // 검색 결과의 총 개수
            total = adminNoticeListService.countSearchKeywordNotice(searchKeyword);
        } else {
            // 검색어가 없는 경우 모든 공지사항을 가져옴
            noticeLists = noticeService.selectAllPageNotice(noticeCriteria);
            total = noticeService.selectTotalNotice();
        }

        // 페이지 처리
        NoticePage noticePage = new NoticePage(noticeCriteria, total);

        // 페이징 정보 가져오기
        model.addAttribute("noticeLists", noticeLists);
        model.addAttribute("page", noticePage);
        model.addAttribute("searchKeyword", searchKeyword);

        return "admin/dam/admin-notice-list";
    }

    //공지 삭제시
    @PostMapping("/noticeList/{noticeId}")
    public String noticeList( @PathVariable("noticeId") long noticeId){
        noticeService.deleteNotice(noticeId);
        return "redirect:/admin/noticeList";
    }

    // 1:1 문의
    @GetMapping("/inquiryList")
    public String inquiryList(InquiryCriteria inquiryCriteria,
                              Model model,
                              @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

        // 검색어가 있을 경우 Criteria에 검색어 설정
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            inquiryCriteria.setKeyword(searchKeyword);
        } else {
            inquiryCriteria.setKeyword(null);
        }

        // 페이징 및 검색 기능 처리
        List<InquiryPagingDTO> adminInquiryLists = adminInquiryService.selectAdminInquiryPage(inquiryCriteria);
        int total = adminInquiryService.selectAdminInquiryTotal(); // 전체 게시물 수를 가져오는 쿼리

        InquiryPage inquiryPage = new InquiryPage(inquiryCriteria, total);

        model.addAttribute("adminInquiryLists", adminInquiryLists);
        model.addAttribute("inquiryPage", inquiryPage);
        model.addAttribute("searchKeyword", searchKeyword);

        return "/admin/dam/admin-inquiry-list";
    }

    //문의글 삭제시
    @PostMapping("/inquiryList/{inquiryId}")
    public String inquiryList( @PathVariable("inquiryId") long inquiryId){
        adminInquiryService.removeInquiry(inquiryId);
        return "redirect:/admin/inquiryList";
    }

    //1:1문의 상세
    @GetMapping("/inquiry/detail")
    public String inquiryDetail(Long inquiryId, Model model){
        InquiryDTO inquiryDetail = adminInquiryService.selectAdminInquiryDetail(inquiryId);

        System.out.println(inquiryDetail.getInquiryId());
        model.addAttribute("inquiryDetail", inquiryDetail);
        return "/admin/admin_tm/admin-inquiry-detail";
    }

    @PostMapping("/inquiry/detail/response")
    public String inquiryDetail(@RequestParam("inquiryId") Long inquiryId, @RequestParam("inquiryResponse") String inquiryResponse){
        System.out.println("id:" + inquiryId);
        System.out.println("response:" + inquiryResponse);
        adminInquiryService.writeAdminResponse(inquiryResponse, inquiryId);
        return "redirect:/admin/inquiryList";
    }

    // 관리자 디테일
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long boardId) {
        BoardVO board = adminBoardListService.everyLifeDetail(boardId);
        model.addAttribute("board", board);

        return "/admin/admin_tm/admin_detail";
    }
}