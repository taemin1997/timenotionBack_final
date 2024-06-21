package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LikeHeartDTO {
    private Long boardId;
    private Long userId;
}
