package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import com.example.geungeunhanjan.mapper.board.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardFileServiceImpl implements  BoardFileService{

    private final BoardFileMapper boardFileMapper;

    //게시글에 파일 넣기
    @Override
    public void registerFile(BoardFileVO boardFileVO) {
        boardFileMapper.insertFile(boardFileVO);


    }

    //게시글에 있는 파일 삭제하기
    @Override
    public void removeFile(Long boardId) {
        boardFileMapper.deleteFile(boardId);
    }

    //게시판에 있는 파일 리스트 뽑기
    @Override
    public List<BoardFileVO> findFileList(Long boardId) {
        return boardFileMapper.selectFileList(boardId);
    }
}

