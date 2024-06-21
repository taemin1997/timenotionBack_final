package com.example.geungeunhanjan.domain.dto.comment;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CommentWriteDTO {
    private Long commentId;
    private String commentContent;
    private LocalDateTime commentCreatedDate;
    private Long boardId;
    private Long userId;
}
