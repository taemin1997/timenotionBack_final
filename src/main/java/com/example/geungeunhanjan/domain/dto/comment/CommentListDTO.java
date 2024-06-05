package com.example.geungeunhanjan.domain.dto.comment;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class CommentListDTO {
    private Long boardId;
    private Long userFileId;
    private Long userId;
    private Long commentId;
    private String nickname;
    private String commentContent;
    private LocalDateTime commentCreatedDate;
    private String userFileProfileName;
    private String userFileProfileSource;
    private String userFileProfileUuid;
}
