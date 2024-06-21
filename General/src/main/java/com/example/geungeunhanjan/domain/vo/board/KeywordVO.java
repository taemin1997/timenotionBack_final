package com.example.geungeunhanjan.domain.vo.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class KeywordVO {
    private Long keywordId;
    private String keywordContent;
    private LocalDateTime keywordTimeStamp;
}
