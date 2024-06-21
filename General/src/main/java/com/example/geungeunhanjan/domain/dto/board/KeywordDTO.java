package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class KeywordDTO {
    private Long keywordId;
    private String keywordContent;
    private LocalDateTime keywordTimeStamp;
    private int count;
}
