package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;

import java.util.List;

public interface BoardFileService {

    //게시글에 파일 넣기
    void registerFile(BoardFileVO boardFileVO);

    //게시글에 있는 파일 삭제
    void removeFile(Long boardId);

    //게시글에 있는 파일 뽑아주기
    List<BoardFileVO> findFileList(Long boardId);

}
