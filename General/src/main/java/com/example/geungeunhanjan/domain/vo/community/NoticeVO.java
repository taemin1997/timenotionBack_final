package com.example.geungeunhanjan.domain.vo.community;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class NoticeVO {
    private Long noticeId;
    private String noticeTitle;
    private String noticeContent;
    private LocalDateTime noticeCreatedDate;
    private Long userId;
    private Long uniId;
}
