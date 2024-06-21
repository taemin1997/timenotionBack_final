package com.example.geungeunhanjan.domain.vo.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ReportVO {
    private Long reportId;
    private String reportReason;
    private LocalDateTime reportCreatedDate;
    private Long userId;
    private Long replyId;
    private Long commentId;
    private int reportCount;
}
