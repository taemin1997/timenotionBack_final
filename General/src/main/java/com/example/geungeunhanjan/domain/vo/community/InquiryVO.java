package com.example.geungeunhanjan.domain.vo.community;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class InquiryVO {
    private Long inquiryId;
    private String inquiryTitle;
    private String inquiryContent;
    private String inquiryResponse;
    private LocalDateTime inquiryCreatedDate;
    private boolean inquiryPublic;
    private Long userId;
    private Long uniId;
}
