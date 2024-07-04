package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.mapper.admin.admin_boardListMapper;
import com.example.geungeunhanjan.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_boardListServiceImpl implements admin_boardListService{

    private final admin_boardListMapper adminBoardListMapper;
    private final BoardMapper boardMapper;

    @Value("C:/upload/")
    private String fileDir;

    // 게시글 업데이트
    @Override
    public void modifyBoard(BoardVO boardVO, List<MultipartFile> files) throws IOException {
        adminBoardListMapper.updateBoard(boardVO);
        Long boardId = boardVO.getBoardId();
    }

    //특정 게시글 조회수 +1
    @Override
    public void boardIntViewCnt(Long boardId) {
        adminBoardListMapper.incViewCnt(boardId);
    }

    //게시글 삭제하기
    @Override
    public void removeBoard(Long boardId) {
        adminBoardListMapper.deleteBoard(boardId);
    }

    //좋아요 삭제하기
    @Override
    public void removeLike(Long likeId) {
        adminBoardListMapper.deleteLike(likeId);
    }

    // 모두의 일대기 게시물
    @Override
    public List<BoardVO> everyLifeBoardbyViews() {
        System.out.println("1===========" + adminBoardListMapper);
        return adminBoardListMapper.everyLifeBoardbyViews();
    }

    //모두의 일대기 게시물 + 페이징 처리
    @Override
    public List<BoardDTO> everyLifeFindPage(Criteria Criteria) {
        return adminBoardListMapper.everyLifeagepaging(Criteria);
    }

    @Override
    public List<BoardDTO> everyLifeFindPage(Map<String, Object> paramMap) {
        return adminBoardListMapper.everyLifeagepaging(paramMap);
    }

    @Override
    public int everyLifeFindTotal() {
        return adminBoardListMapper.everyLifeFindTotal();
    }

    // 최신순 게시판 정렬
    @Override
    public List<BoardDTO> getPostsSortedByLatest() {
        return List.of();
    }

    // 모두의 일대기 -> 상세페이지 넘어가기
    @Override
    public BoardVO everyLifeDetail(Long boardId) {
        return adminBoardListMapper.selectById(boardId).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시물 번호"));
    }

    //내가 쓴 게시물의 상세페이지 들어가기
    @Override
    public BoardVO selectById(Long boardId) {
        return boardMapper.selectById(boardId).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시물 번호"));
    }

    //특정 회원의 게시글 보기(마이페이지)
    @Override
    public List<BoardVO> selectBoard(Long userId) {
        return adminBoardListMapper.selectBoard(userId);
    }

    //게시글 작성자의 닉네임
    @Override
    public String boardUserName(Long boardId) {
        return adminBoardListMapper.boardUserName(boardId);
    }

    // 모두의 일대기 프사 불러오기
    @Override
    public List<BoardDTO> getProfile(Long userId) {
        return adminBoardListMapper.getProfile(userId);
    }

    //특정 회원의 생일 불러오기
    @Override
    public LocalDateTime writerUserBirth(Long userId) {
        return adminBoardListMapper.selectUserBirth(userId);
    }
}
