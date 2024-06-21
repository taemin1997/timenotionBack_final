package com.example.geungeunhanjan.mapper.board;

import com.example.geungeunhanjan.domain.dto.board.KeywordDTO;
import com.example.geungeunhanjan.domain.vo.board.KeywordSearchCountVO;
import com.example.geungeunhanjan.domain.vo.board.KeywordVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeywordMapper {
    //검색한 키워드 저장
    void keywordInsert(KeywordVO keywordVO);

    //검색한 키워드가 검색 전적이 있는지 확인하기위한 코드
    KeywordVO selectKeywordContent(String keywordContent);

    //누적합하는 코드
    void increamentSearchCount(String keywordContent);
}
