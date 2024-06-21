package com.example.geungeunhanjan.mapper.board;

import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardFileMapper {
    //게시글에 파일 넣기
    void insertFile(BoardFileVO boardFileVO);

    //게시글에 있는 파일 뽑아주기
    List<BoardFileVO> selectFileList(Long boardId);

    //게시글에 있는 파일 삭제하기
    void deleteFile(Long BoardId);

}
