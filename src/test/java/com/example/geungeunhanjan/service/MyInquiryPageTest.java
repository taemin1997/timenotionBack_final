package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.dto.lifePage.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
public class MyInquiryPageTest {
    @Autowired
    private MyPageService myPageService;


    @Test
    public void selectMyCommentTest() {
        System.out.println(myPageService.selectMyComment(1L));
    }

    @Test
    public void selectMyLikeTest() {
        System.out.println(myPageService.selectMyLike(1L));
    }

    @Test
    public void selectMyCommentsTest() {
//        Long userId = 1L;
//        Criteria criteria = new Criteria();
//        List<CommentDTO> comments = myPageService.findPageMyComment(criteria, userId);
//        int total = myPageService.myCommentTotal(userId);
//        Page page = new Page(criteria, total);
//
//        // Assertions
//        assertNotNull(page);
//        assertEquals(1, page.getCriteria().getPage());
//        assertEquals(10, page.getCriteria().getAmount());
//        assertEquals(total, page.getTotal());

//        assertThat(page).isNotNull().extracting("pageCount")
    }



}