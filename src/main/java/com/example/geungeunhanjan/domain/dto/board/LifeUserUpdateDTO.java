package com.example.geungeunhanjan.domain.dto.board;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class LifeUserUpdateDTO {
    private Long userId;
//    private Long kakaoId;
//    private Long uniId;
    /* update About*/
    private String uniAbout;

    /* update User */
    private String nickname;
    private LocalDateTime userBirth;
//    private String userPassword;

    /* update Kakao*/
//    private String name;
}
