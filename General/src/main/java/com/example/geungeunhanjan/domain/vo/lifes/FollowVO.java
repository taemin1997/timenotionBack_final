package com.example.geungeunhanjan.domain.vo.lifes;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FollowVO {
//    followtouser, followFromUser -> int에서 Long으로 변경해야함
    private Long followId;
    private Long followToUser;
    private Long followFromUser;
}
