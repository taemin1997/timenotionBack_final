package com.example.geungeunhanjan.domain.dto.community;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class InquiryDTO {
    private long inquiryId;
    private String inquiryTitle;
    private String userNickname;
    private LocalDateTime inquiryCreatedDate;
    private String inquiryContent;
    private String inquiryResponse;
    private String inquiryPublic;
    private Long userId;
    private Long loginUserId;
    private Long uniId;
}
