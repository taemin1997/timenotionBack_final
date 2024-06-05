package com.example.geungeunhanjan.service.board;


import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;

import com.example.geungeunhanjan.domain.dto.board.BoardMainDTO;

import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface BoardService {

    //게시글 등록하기
    void registerBoard(BoardVO boardVO);

    //게시글 업데이트
    void modifyBoard(BoardVO boardVO, List<MultipartFile> files)  throws IOException;

    //게시글 삭제하기
    void removeBoard(Long boardId);

    //일대기별 게시글 조회
    List<BoardVO> selectLifeCycle(String boardLifeCycle, Long userId);

    //특정 게시긓 조회수 +1
    void boardIntViewCnt(Long boardId);

    //게시글 파일 같이 등록하기
    void registerBoardwithFile(BoardVO boardVO, List<MultipartFile> files)  throws IOException;

    //파일 저장하기
    BoardFileVO saveFile(MultipartFile files) throws IOException;

    //특정 회원의 생일 불러오기
    LocalDateTime writerUserBirth(Long userId);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

    //내가 쓴 게시물의 상세페이지 들어가기
    BoardVO selectById(Long boardId);

    // 메인 4칸짜리 게시물
    List<BoardMainDTO> mainBoardbyViews();


    // 모두의 일대기 게시물
    List<BoardVO> everyLifeBoardbyViews();

    //모두의 일대기 게시물 + 페이징 처리 //
    List<BoardDTO> everyLifeFindPage(Criteria criteria);

    int everyLifeFindTotal();


//    String everyLifeFindTotal(); //주석처리

//    //    조회수, 인기수 , 최신순 게시판 정렬
    List<BoardDTO> getBoards(String orderBy);

    // 모두의 일대기 -> 상세페이지 넘어가기
     BoardVO everyLifeDetail(Long UserId);


    List<BoardDTO> getPostsSortedByViews();

    List<BoardDTO> getPostsSortedByLatest();

    List<BoardDTO> getPostsSortedByPopularity();


    // 메인 배너 왼쪽
    BoardMainDTO mainLeftBannerSelect();

    List<BoardMainDTO> mainRightBannerSelect();

}







