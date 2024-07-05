package com.example.geungeunhanjan.mapper.admin;

import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface admin_boardListMapper {

    //게시글 업데이트
    void updateBoard(BoardVO boardVO);

    //특정 게시판 조회수 +1
    int incViewCnt(Long boardId);

    //게시글 삭제하기
    void deleteBoard(Long boardId);

    //좋아요 삭제하기
    void deleteLike(Long likeID);

    // 모두의 일대기 게시물
    List<BoardVO> everyLifeBoardbyViews();

    // 모두의 일대기 리스트 + 페이징
    List<BoardDTO> everyLifeagepaging(Criteria Criteria);

    //검색 결과 조회
    List<BoardDTO> everyLifeagepaging(Map<String, Object> paramMap);

    int everyLifeFindTotal(); //selectTotal

    // 최신순 게시판 정렬
    List<BoardDTO> postarrayLatest();

    //내가쓴 특정게시물 상세페이지 들어가기
    Optional<BoardVO> selectById(Long boardId);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    // 게시글 작성자의 닉네임
    String boardUserName(Long boardId);

    // 프로필 가져오기
    List<BoardDTO> getProfile(Long userId);

    //특정 회원의 생일 불러오기
    LocalDateTime selectUserBirth(Long userId);
}
