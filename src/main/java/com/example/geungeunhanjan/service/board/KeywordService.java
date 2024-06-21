package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.dto.board.KeywordDTO;
import com.example.geungeunhanjan.domain.vo.board.KeywordVO;
import org.springframework.stereotype.Service;

@Service
public interface KeywordService {
    void keywordInsert(KeywordVO keywordVO);

    KeywordDTO keywordCountSelect();
}
