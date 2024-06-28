package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.NoticePage.NoticePage;
import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
<<<<<<< HEAD
import com.example.geungeunhanjan.domain.dto.board.LifeUserInfoDTO;
=======
>>>>>>> fb1a890c9641ef80b8c4560dac35f15fb16fb792
import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.community.MemberDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryPage;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.service.admin.admin_boardListService;
import com.example.geungeunhanjan.service.admin.admin_inquiryService;
import com.example.geungeunhanjan.service.admin.admin_memberListService;
import com.example.geungeunhanjan.service.admin.admin_noticeListService;
import com.example.geungeunhanjan.service.community.NoticeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> fb1a890c9641ef80b8c4560dac35f15fb16fb792
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class adminController {

    private final admin_boardListService adminBoardListService;
    private final admin_inquiryService adminInquiryService;
    private final NoticeService noticeService;
    private final admin_noticeListService adminNoticeListService;
    private final admin_memberListService adminMemberListService;

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
        //검색기능 추가
        if(searchKeyword != null && !searchKeyword.isEmpty()) {
            //검색어가 있는경우 검색 결과를 가져옴
            memberLists = adminMemberListService.adminSelectMember(paramMap);
            System.out.println("memberLists = " + memberLists);
            total = memberLists.size(); //검색결과의 총 개수
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
    public String reportList() {
        return "/admin/dam/admin-report-list";
    }

    // 공지사항 관리
    @GetMapping("/noticeList")
    public String noticeList(Model model,
                             NoticeCriteria noticeCriteria,
                             HttpServletRequest request,
                             @RequestParam(value = "searchKeyword", required = false) String searchKeyword
                             ) {
        List<NoticePageDTO> noticeLists;
        int total  ;


        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("keyword", searchKeyword);
        paramMap.put("page", noticeCriteria.getPage());
        paramMap.put("amount", noticeCriteria.getAmount());

        //검색기능 추가
        if(searchKeyword != null && !searchKeyword.isEmpty()) {
            //검색어가 있는경우 검색 결과를 가져옴
            noticeLists = adminNoticeListService.adminSelectNotice(paramMap);
            total = noticeLists.size(); //검색결과의 총 개수
        }else{
            //검색어가 없는 경우 모든 공지사항을 가져옴
            noticeLists = noticeService.selectAllPageNotice(noticeCriteria);
            total = noticeService.selectTotalNotice();
        }

        //페이지 처리
        NoticePage noticePage = new NoticePage(noticeCriteria, total);

        //페이징 정보 가져오기
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
    public String inquiryList(InquiryCriteria inquiryCriteria, Model model) {

        List<InquiryPagingDTO> inquiries = adminInquiryService.selectAdminInquiryPage(inquiryCriteria);

        int total = adminInquiryService.selectAdminInquiryTotal();

        InquiryPage inquiryPage = new InquiryPage(inquiryCriteria, total);

        model.addAttribute("inquiries", inquiries);
        model.addAttribute("inquiryPage", inquiryPage);
        return "/admin/dam/admin-inquiry-list";
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