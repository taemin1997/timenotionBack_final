package com.example.geungeunhanjan.comment;

import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.service.comment.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CommentTest {
    @Autowired
    CommentService commentService;

    @Test
    void mypageCommentList() {
        Criteria criteria = new Criteria(1, 10); // 페이지 번호와 한 페이지당 게시물 수를 지정하여 Criteria 객체를 초기화
        System.out.println(commentService.findCommentSlice(criteria, 13L));
    }
}
