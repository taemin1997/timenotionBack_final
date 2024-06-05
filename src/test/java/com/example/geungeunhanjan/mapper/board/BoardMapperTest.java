package com.example.geungeunhanjan.mapper.board;

import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;


    //insertboard 테스트
    @Test
    void insertBoard() {
        BoardVO boardVO = new BoardVO();
        LocalDateTime currentDateTime = LocalDateTime.now();

        boardVO.setBoardId(1L);
        boardVO.setBoardTitle("asd");
        boardVO.setBoardContent("asdaadd");
        boardVO.setBoardPublic("O");
        boardVO.setBoardCreatedDate(currentDateTime);
        boardVO.setBoardUpdatedDate(currentDateTime);
        boardVO.setBoardViewCount(3);
        boardVO.setBoardLifeCycle("청년기");
        boardVO.setBoardYear(1988);
        boardVO.setBoardLikeCount(0);
        boardVO.setUserId(1L);
        System.out.println(boardVO);
        System.out.println(boardVO.getBoardLifeCycle());
        boardMapper.insertBoard(boardVO);
        System.out.println(boardVO);

    }

//    게시판 작성자의 생일 가져오기 테스트
    @Test
    public void writerUserBirthTest() {
        System.out.println(boardMapper.selectUserBirth(1L));
    }

    @Test
<<<<<<< HEAD
<<<<<<< HEAD
    void test(){
        Criteria criteria = new Criteria();


        System.out.println(criteria);

        System.out.println(boardMapper.everyLifeagepaging(criteria));

    }

}
=======
    public void selectLifeCycle(String boardLifeCycle, Long userId) {
        boardLifeCycle = "청소년기";
        userId = 1L;
        System.out.println(boardService.selectLifeCycle(boardLifeCycle,userId));
=======
    void test(){
        Criteria criteria = new Criteria();
>>>>>>> main


        System.out.println(criteria);

        System.out.println(boardMapper.everyLifeagepaging(criteria));

    }

<<<<<<< HEAD
>>>>>>> main
=======
}
>>>>>>> main
