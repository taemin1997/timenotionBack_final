package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.dto.board.KeywordDTO;
import com.example.geungeunhanjan.domain.vo.board.KeywordSearchCountVO;
import com.example.geungeunhanjan.domain.vo.board.KeywordVO;
import org.springframework.stereotype.Service;

@Service
public interface KeywordService {
    //검색한 키워드 저장
    void keywordInsert(KeywordVO keywordVO);


    //검색한 키워드가 검색 전적이 있는지 확인하기위한 코드
    KeywordVO selectContent(String keywordContent);

    //누적합하는 코드
    void increamentCount(String keywordContent);

    //검색전적이 있을경우 누접합을 하는 코드
    void keywordIncreament(KeywordVO keywordVO, String keywordContent);
}
