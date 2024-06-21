package com.example.geungeunhanjan.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UniVO {
    private Long uniId;
    private String uniStatus;
    private String uniAbout;
    private Long userId;
    private Long kakaoId;
}
