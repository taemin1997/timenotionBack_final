package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ReportDTO {
    private int rowNumber;
    private Long reportId;
    private String reportReason;
    private LocalDateTime reportCreatedDate;
    private int reportCount;
    private Long reporterId; // 신고자 id
    private Long reportedCommentId; // 신고 당한 댓글 id
}
