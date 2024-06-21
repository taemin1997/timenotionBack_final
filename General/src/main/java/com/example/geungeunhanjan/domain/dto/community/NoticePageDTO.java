package com.example.geungeunhanjan.domain.dto.community;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class NoticePageDTO {

    private Long noticeId;
    private String noticeTitle;
    private String noticeContent;
    private String userNickname; // 추가된 필드
    private LocalDateTime noticeCreatedDate;

}
