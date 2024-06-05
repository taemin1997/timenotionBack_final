package com.example.geungeunhanjan.domain.dto.file;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FollowHeartDTO {
    private Long followToUser;
    private Long followFromUser;
}
