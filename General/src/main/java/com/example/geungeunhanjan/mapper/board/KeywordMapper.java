package com.example.geungeunhanjan.mapper.board;

import com.example.geungeunhanjan.domain.dto.board.KeywordDTO;
import com.example.geungeunhanjan.domain.vo.board.KeywordVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeywordMapper {
    void keywordInsert(KeywordVO keywordVO);

    KeywordDTO keywordCountSelect();
}
