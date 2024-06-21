package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserInfoDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.mapper.admin.admin_boardListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_boardListServiceImpl implements admin_boardListService{

    private final admin_boardListMapper adminBoardListMapper;


    @Override
    public void modifyBoard(BoardVO boardVO, List<MultipartFile> files) throws IOException {
        adminBoardListMapper.updateBoard(boardVO);
        Long boardId = boardVO.getBoardId();
    }

    @Override
    public void removeBoard(Long boardId) {
        adminBoardListMapper.deleteBoard(boardId);
    }

    @Override
    public List<BoardVO> selectLifeCycle(String boardLifeCycle, Long userId) {
        return adminBoardListMapper.selectBoardLifeCycle(boardLifeCycle, userId);
    }

    @Override
    public List<BoardDTO> everySearchBoards(String keyword) {
        return adminBoardListMapper.searchBoards(keyword);
    }

    @Override
    public List<BoardDTO> everyLifeCycle(String boardLifeCycle) {
        return adminBoardListMapper.selectEveryLifeCycle(boardLifeCycle);
    }

    @Override
    public void boardIntViewCnt(Long boardId) {
        adminBoardListMapper.incViewCnt(boardId);
    }


    @Override
    public LocalDateTime writerUserBirth(Long userId) {
        return adminBoardListMapper.selectUserBirth(userId);
    }

    @Override
    public List<BoardVO> selectBoard(Long userId) {
        return adminBoardListMapper.selectBoard(userId);
    }

    @Override
    public BoardVO selectById(Long boardId) {
        return adminBoardListMapper.selectById(boardId).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시물 번호"));
    }

    @Override
    public List<BoardVO> everyLifeBoardbyViews() {
        System.out.println("1===========" + adminBoardListMapper);
        return adminBoardListMapper.everyLifeBoardbyViews();
    }

    @Override
    public BoardVO everyLifeDetail(Long boardId) {
        System.out.println(boardId);
        return adminBoardListMapper.selectById(boardId).orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시물 번호"));
    }

    @Override
    public List<BoardDTO> everyLifeFindPage(Criteria criteria) {
        System.out.println("===============" + adminBoardListMapper);
        System.out.println("===============" + criteria + "==========================");
        System.out.println(adminBoardListMapper.everyLifeagepaging(criteria));
        return adminBoardListMapper.everyLifeagepaging(criteria);
    }

    @Override
    public int everyLifeFindTotal() {
        return adminBoardListMapper.everyLifeFindTotal();
    }

    @Override
    public String boardUserName(Long boardId) {
        return adminBoardListMapper.boardUserName(boardId);
    }
}
