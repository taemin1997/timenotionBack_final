package com.example.geungeunhanjan.domain.dto.community;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
// 문의 페이징
public class InquiryPagingDTO {
    private long inquiryId;
    private String inquiryTitle;
    private String nickname;
    private LocalDateTime inquiryCreatedDate;
    private String inquiryContent;
    private String inquiryResponse;
    private String inquiryPublic;
    private Long userId;

}

