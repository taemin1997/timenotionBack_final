package com.example.geungeunhanjan.domain.dto.community;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
// 문의 작성
public class InquiryWriteDTO {
    private Long inquiryId;
    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryResponse;
    private LocalDateTime inquiryCreatedDate;
    private String inquiryPublic;
    private Long userId;
    private String userNickname;
    private Long uniId;
}
