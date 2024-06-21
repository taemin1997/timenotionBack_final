package com.example.geungeunhanjan.controller.lifes;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.board.BoardService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MyInquiryPageControllerTest {
    private static final Logger log = LoggerFactory.getLogger(MyInquiryPageControllerTest.class);
    @Autowired
    MyPageService myPageService;

    @Autowired
    BoardService boardService;

    CommentDTO commentDTO;

    @Test
    void mypageCommentList() {
        commentDTO = new CommentDTO();
        commentDTO.setUserId(1L);
        commentDTO.setCommentsContent("안녕");
        commentDTO.setBoardTitle("제목 !!!");
        commentDTO.setCreatedDate(LocalDateTime.now());
        commentDTO.setBoardId(1L);
        Criteria criteria = new Criteria();
        criteria.setPage(1);
        criteria.setAmount(10);
        List<CommentDTO> comments
                = myPageService.findPageMyComment(criteria, 1L);
        Page page = new Page(criteria, comments.size());

        assertNotNull(page);
        assertEquals(1, page.getCriteria().getPage());
        assertEquals(10, page.getCriteria().getAmount());
        assertEquals(1, page.getStartPage());
        assertTrue(page.getEndPage() >= 1);
        assertFalse(page.isPrev());
        assertFalse(page.isNext());
        System.out.println(comments.size()
                + "  PageCount: " + page.getPageCount()
                + "  StartPage : " + page.getStartPage()
                + "  EndPage : " + page.getEndPage()
                + "  RealEndPage : " + page.getRealEnd()
                + "  Comment-BoardId : " + comments.get(1).getBoardId()
                + "  Comment-Content : " + comments.get(1).getCommentsContent());

        // 추가적인 검증
        assertEquals(5, page.getPageCount()); // 수정된 값
        assertEquals(comments.size(), page.getTotal());
        assertEquals((int) Math.ceil(comments.size() / (double) criteria.getAmount()), page.getRealEnd());

    }
    }