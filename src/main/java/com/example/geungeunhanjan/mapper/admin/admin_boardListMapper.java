package com.example.geungeunhanjan.mapper.admin;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface admin_boardListMapper {

    //게시글 업데이트
    void updateBoard(BoardVO boardVO);

    //게시글 삭제하기
    void deleteBoard(Long boardId);

    //모두의 일대기 별 게시판 조회
    List<BoardDTO> selectEveryLifeCycle(String boardLifeCycle);

    //모두의 일대기 검색 결과 조회
    List<BoardDTO> searchBoards(@Param("keyword") String keyword);

    //내가쓴 특정게시물 상세페이지 들어가기
    Optional<BoardVO> selectById(Long boardId);

    //일대기 별 게시판 조회하기
    List<BoardVO> selectBoardLifeCycle(String boardLifeCycle, Long userId);

    //특정 회원의 생일 불러오기
    LocalDateTime selectUserBirth(Long userId);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    //특정 게시판 조회수 +1
    int incViewCnt(Long boardId);

    // 모두의 일대기 게시물
    List<BoardVO> everyLifeBoardbyViews();

    // 모두의 일대기 리스트 + 페이징
    List<BoardDTO> everyLifeagepaging(Criteria criteria);

    int everyLifeFindTotal(); //selectTotal

    String boardUserName(Long boardId);

}
