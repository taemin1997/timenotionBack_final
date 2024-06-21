package com.example.geungeunhanjan.service.board;

import com.example.geungeunhanjan.domain.dto.board.KeywordDTO;
import com.example.geungeunhanjan.domain.vo.board.KeywordSearchCountVO;
import com.example.geungeunhanjan.domain.vo.board.KeywordVO;
import com.example.geungeunhanjan.mapper.board.KeywordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordServiceimpl implements KeywordService {

    private final KeywordMapper keywordMapper;

    //검색한 키워드 저장
    @Override
    public void keywordInsert(KeywordVO keywordVO) {
        keywordMapper.keywordInsert(keywordVO);
    }

    //검색한 키워드가 검색 전적이 있는지 확인하기위한 코드
    @Override
    public KeywordVO selectContent(String keywordContent) {
        return keywordMapper.selectKeywordContent(keywordContent);
    }

    //누적합하는 코드
    @Override
    public void increamentCount(String keywordContent) {
        keywordMapper.increamentSearchCount(keywordContent);
    }

    //검색전적이 있을경우 누접합을 하는 코드
    @Override
    public void keywordIncreament(KeywordVO keywordVO, String keywordContent) {
        KeywordVO keywordVO1 = selectContent(keywordContent);

        if(keywordVO1 == null){
            keywordVO.setKeywordContent(keywordContent);
            keywordMapper.keywordInsert(keywordVO);
        }else{
            keywordMapper.increamentSearchCount(keywordContent);
        }

    }


}
