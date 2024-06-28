package com.example.geungeunhanjan.controller.lifes;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.domain.dto.user.UserDTO;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.user.UserVO;
import com.example.geungeunhanjan.mapper.board.BoardMapper;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// 모두의 일대기로
@Controller
@RequestMapping("/everyLife")
@RequiredArgsConstructor
public class EveryLifeController {

    private final BoardService boardService;
    private final UserService userService;
    private final UserVO userVO;
    private final BoardDTO boardDTO;
    private final BoardVO boardVO;
    private final BoardMapper boardMapper;
    private final InquiryCriteria inquiryCriteria;

    @GetMapping()
    public String everyLife(Model model, HttpSession session, Criteria criteria,
                            @RequestParam(required = false, defaultValue = "latest") String sort) {
        // 로그인 여부 확인
        Long userId = (Long) session.getAttribute("uniId");
        if (userId == null) {
            return "redirect:/user/login";
        }


        // 페이징 처리를 위한 코드
        criteria.setAmount(12);
        List<BoardDTO> boardLists = boardService.everyLifeFindPage(criteria);

        int total = boardService.everyLifeFindTotal();
        Page page = new Page(criteria, total);
        model.addAttribute("boardLists", boardLists); // 실제로 가져온 게시물 리스트를 모델에 추가
        model.addAttribute("page", page);
        model.addAttribute("sort", sort);

        return "everyLife/everyLife"; // 페이지 이름 반환
    }



    //모두의 일대기 -> 상세페이지 이동
    @GetMapping("/detail-others/{id}")
    public String everyDetail(Model model, @PathVariable("id") Long boardId) {
        BoardVO board = boardService.everyLifeDetail(boardId);
        model.addAttribute("board", board);

        return "everyLife/detail-others";
    }

}

