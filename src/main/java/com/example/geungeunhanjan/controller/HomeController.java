package com.example.geungeunhanjan.controller;

import com.example.geungeunhanjan.domain.dto.board.BoardMainDTO;

import com.example.geungeunhanjan.domain.dto.user.UserFileNicknameDTO;
import com.example.geungeunhanjan.mapper.user.UserMapper;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.community.InquiryService;
import com.example.geungeunhanjan.service.user.UserService;

import jakarta.servlet.http.HttpSession;

import com.example.geungeunhanjan.service.lifes.FollowService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
@AllArgsConstructor
public class HomeController {
    // 여기서 HttpSession 사용해서 로그인 관리 해봤는데
    // 이거 때문에 로그인 해야지 원하는 화면으로 가실 수 있어서
    // 불편하시면 빼고 진행해주시면 감사하겠습니다
    // HttpSession만 빼면 됩니다

    private final BoardService boardService;
    private final UserService userService;


    private final FollowService followService;


    @GetMapping
    public String index(Model model, HttpSession session) {
        // 로그인 여부 확인


        BoardMainDTO mainLeft = boardService.mainLeftBannerSelect();
        List<BoardMainDTO> boards = boardService.mainBoardbyViews();
        List<BoardMainDTO> rightBoards = boardService.mainRightBannerSelect();

        System.out.println("mainLeft = " + mainLeft);


        model.addAttribute("mainLeft", mainLeft);
        model.addAttribute("boards", boards);
        model.addAttribute("rightBoards", rightBoards);

        System.out.println(boards);

        return "main/index";
    }

    public String mainContentsByViews(){

        return "myLife/detail-others";
    }



    @GetMapping("/about")
    public String about(HttpSession session) {

        // 로그인 여부 확인

        Long uniId = (Long) session.getAttribute("uniId");
        if (uniId == null) {

            return "redirect:/user/login";
        }
        return "main/about";
    }

}