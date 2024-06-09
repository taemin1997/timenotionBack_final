package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.mapper.board.BoardMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private BoardVO boardVO;


    @Test
    public void testGetBoardByLifeCycleAndUser(@Param("boardLifeCycle") String boardLifeCycle, @Param("userId") Long userId) {
        boardVO.setBoardLifeCycle("유아기");
        boardVO.setUserId(1L);

        System.out.println( boardService.selectLifeCycle(boardLifeCycle, userId));

    }
}