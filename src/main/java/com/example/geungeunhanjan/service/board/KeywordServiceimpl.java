package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.dto.board.KeywordDTO;
import com.example.geungeunhanjan.domain.vo.board.KeywordVO;
import com.example.geungeunhanjan.mapper.board.KeywordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordServiceimpl implements KeywordService {

    private final KeywordMapper keywordMapper;

    @Override
    public void keywordInsert(KeywordVO keywordVO) {
        keywordMapper.keywordInsert(keywordVO);
    }

    @Override
    public KeywordDTO keywordCountSelect() {
        return keywordMapper.keywordCountSelect();
    }
}
