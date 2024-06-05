package com.example.geungeunhanjan.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class UserVO {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userNickname;
    private LocalDateTime userBirth;

}
