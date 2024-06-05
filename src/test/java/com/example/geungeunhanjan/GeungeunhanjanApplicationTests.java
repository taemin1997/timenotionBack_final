package com.example.geungeunhanjan;
<<<<<<< HEAD
<<<<<<< HEAD
import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;


=======

=======
>>>>>>> main
import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;

>>>>>>> main


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;

import com.example.geungeunhanjan.domain.vo.user.UserVO;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.mapper.board.BoardMapper;

import com.example.geungeunhanjan.mapper.community.InquiryMapper;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.community.InquiryService;
import com.example.geungeunhanjan.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class GeungeunhanjanApplicationTests {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserVO userVO;
    LocalDateTime dateTime;

<<<<<<< HEAD
<<<<<<< HEAD
=======



    @Autowired

>>>>>>> main
=======
>>>>>>> main
    private BoardMapper boardMapper;

    @Autowired
    private InquiryMapper inquiryMapper;
    @Qualifier("inquiryService")
    @Autowired
    private InquiryService inquiryService;


    @Test
    void contextLoads() {
    }
    @Test
    void selectBoardTest() {
        List<BoardVO> boards = boardService.selectBoard(1L);
        System.out.println(boards);
    }


/*    @Test

    @Test


    void mainBoardTest(){
        List<BoardVO> boards = boardService.mainBoardbyViews();
        System.out.println(boards);
    }


    public void insertBoardTest(BoardVO boardVO) {
        Long boardId = boardMapper.getSeq();
        boardVO.setBoardId(boardId);
        boardMapper.insertBoard(boardVO);
        System.out.println(boardVO);
    }




    public void insertBoardTest(BoardVO boardVO) {
        Long boardId = boardMapper.getSeq();
        boardVO.setBoardId(boardId);
        boardMapper.insertBoard(boardVO);
        System.out.println(boardVO);
    }*/



//    public void insertBoardTest(BoardVO boardVO) {
//        Long boardId = boardMapper.getSeq();
//        boardVO.setBoardId(boardId);
//        boardMapper.insertBoard(boardVO);
//        System.out.println(boardVO);
//    }


    @Test
    void userNickTest(){
        String nickname = userService.mainBoardByViewsNickname(1L);
        System.out.println(nickname);
    }

    @Test
    void loginTest(){
        long result = userService.userLogin("user1@example.com", "password1");
        System.out.println(result);
    }

    @Test
    void joinTest(){
        userVO.setUserId(51L);
        userVO.setUserName("as");
        userVO.setUserPassword("1234");
        userVO.setUserEmail("ab@ab.com");
        userVO.setUserNickname("as");
        userVO.setUserBirth(dateTime);

        userService.userJoin(userVO);

    }

    @Test
    void userNickName(){
        String nickname = userService.selectUserNickname(1L);
        System.out.println(nickname);
    }

    @Test
    void inquiryDetailTest(){
        InquiryDTO inquiryDTO = new InquiryDTO();
        String userNickname = userService.selectUserNickname(1L);

        System.out.println(inquiryMapper.selectInquiryDetail(1L));

    }

    @Test
    void inquiryDeleteTest(){
        inquiryMapper.inquiryDelete(1L, 1L);
    }

    @Test
    void paging(InquiryCriteria inquiryCriteria){
        inquiryService.selectAllInquiryPage(inquiryCriteria);
    }
}
