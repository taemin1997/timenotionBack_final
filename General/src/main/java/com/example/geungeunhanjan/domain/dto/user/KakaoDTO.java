package com.example.geungeunhanjan.domain.dto.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class KakaoDTO {
    private Long kakaoId;
    //    private String kakaoUserEmail;
//    private String kakaoPassword;
//    private String kakaoUserNickname;
//    private LocalDateTime kakaoUserBirth;
//    private Long userId;
    private String name; //사용자이름
    private String profilePic; //프로필사진 url
    private String provider; //인증 제공자
    private String providerId; // 제공자의 사용자 고유id
    private LocalDateTime createAt; //생성 시간
    private LocalDateTime updateAt; //수정 시간
    private LocalDateTime kakaoBirth;
}
