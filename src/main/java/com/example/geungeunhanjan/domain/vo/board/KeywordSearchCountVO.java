package com.example.geungeunhanjan.domain.vo.board;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class KeywordSearchCountVO {
    private Long keywordId;
    private String keywordContent;
}
