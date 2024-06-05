package com.example.geungeunhanjan.controller.lifes;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.service.board.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class EveryLifeControllerTest {
 /*   private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardPublic;
    private LocalDateTime boardCreatedDate;
    private LocalDateTime boardUpdatedDate;
    private int boardViewCount;
    private String boardLifeCycle;
    private int boardLikeCount;
    private int boardYear;
    private Long userId;
    private String userNickname;
    private String userFileProfileSource;
    private String userFileProfileName;
    private String userFileProfileUuid;*/
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> main
//    @Autowired
//    BoardService boardService;
//
//    BoardDTO aa;
//
//    @Test
//    void everyLife() {
//        aa = new BoardDTO();
//        aa.setBoardId(100L);
//        aa.setBoardTitle("제목입니다  =====");
//        aa.setBoardLifeCycle("청소년기");
//        aa.setBoardContent("게시글 내용 들어간것것거성러아ㅓㄹ미ㅏㅓㄹ ");
//        aa.setBoardCreatedDate(LocalDateTime.now());
//
//
<<<<<<< HEAD
//        Criteria criteria = new Criteria();
//        criteria.setAmount(9);
//        criteria.setPage(1);
////        List<BoardDTO> boards = boardService.everyLifeFindPage(criteria);
=======
    @Autowired
    BoardService boardService;

    BoardDTO aa;

    @Test
    void everyLife() {
        aa = new BoardDTO();
        aa.setBoardId(100L);
        aa.setBoardTitle("제목입니다  =====");
        aa.setBoardLifeCycle("청소년기");
        aa.setBoardContent("게시글 내용 들어간것것거성러아ㅓㄹ미ㅏㅓㄹ ");
        aa.setBoardCreatedDate(LocalDateTime.now());


//        Criteria criteria = new Criteria();
//        criteria.setAmount(9);
//        criteria.setPage(1);
//        List<BoardDTO> boards = boardService.everyLifeFindPage(Criteria criteria, String boardLifeCycle);
>>>>>>> main
=======
//        Criteria criteria = new Criteria();
//        criteria.setAmount(9);
//        criteria.setPage(1);
////        List<BoardDTO> boards = boardService.everyLifeFindPage(criteria);
>>>>>>> main
//        Page page = new Page(criteria, boards.size());
//
//        System.out.println("게시글 총 길이 : " + boards.size());
//        System.out.println("PageCount : " + page.getPageCount() + "StartPage : " + page.getStartPage());
//        System.out.println("EndPage : " + page.getEndPage() + "RealEnd : " + page.getRealEnd());
//        System.out.println("BoardId : " + aa.getBoardId() + "Content : " + aa.getBoardContent());
////        System.out.println("Total Count : " + boardService.everyLifeFindTotal());
<<<<<<< HEAD
<<<<<<< HEAD
//
//
//    }
=======


    }
>>>>>>> main
=======
//
//
//    }
>>>>>>> main
}