package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface admin_boardListService {

    //게시글 업데이트
    void modifyBoard(BoardVO boardVO, List<MultipartFile> files)  throws IOException;

    //특정 게시글 조회수 +1
    void boardIntViewCnt(Long boardId);

    //게시글 삭제하기
    void removeBoard(Long boardId);

    // 모두의 일대기 게시물
    List<BoardVO> everyLifeBoardbyViews();

    //모두의 일대기 게시물 + 페이징 처리 //
    List<BoardDTO> everyLifeFindPage(Criteria criteria);

    int everyLifeFindTotal();

    // 최신순 게시판 정렬
    List<BoardDTO> getPostsSortedByLatest();

    // 모두의 일대기 -> 상세페이지 넘어가기
    BoardVO everyLifeDetail(Long UserId);

    //내가 쓴 게시물의 상세페이지 들어가기
    BoardVO selectById(Long boardId);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    //게시글 작성자의 닉네임
    String boardUserName(Long boardId);

    // 모두의 일대기 프사 불러오기
    List<BoardDTO> getProfile(Long userId);

    //특정 회원의 생일 불러오기
    LocalDateTime writerUserBirth(Long userId);
}
