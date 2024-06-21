package com.example.geungeunhanjan.domain.vo.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class LikeVO {
    private Long likeId;
    private Long boardId;
    private Long userId;
    private Date likeCreatedDate;
}
