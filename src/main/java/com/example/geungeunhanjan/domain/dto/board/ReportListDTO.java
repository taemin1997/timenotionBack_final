package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ReportListDTO {

    private Long reportId;
    private Long boardId;
    private Long userId;
    private Long commentId;

    private String reportReason;
    private LocalDateTime reportCreatedDate;
    private int reportCount;
    private String commentContent; // 추가됨
    private LocalDateTime commentCreatedDate; // 추가됨
    private String uniStatus;
    private String nickname;

}
