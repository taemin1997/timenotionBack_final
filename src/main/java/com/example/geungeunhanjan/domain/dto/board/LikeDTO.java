package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LikeDTO {
    private Long likeId;
    private String boardTitle;
    private Long boardId;
    private String nickname;
    private Long userId;
    private LocalDateTime likeCreatedDate;
    private Long uniId;

}
