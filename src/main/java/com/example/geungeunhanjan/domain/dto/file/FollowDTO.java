package com.example.geungeunhanjan.domain.dto.file;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FollowDTO {

    private Long followerId; //팔로워아이디
    private String userNickname; //유저 닉네임
//  팔로잉 수
    private int followingCount;// 팔로잉 수 추가된 필드
//  팔로워 수
    private int followerCount;
    private int boardCount;// 일기 수
    private String userFileProfileSource;//파일 소스 추가필드
    private String userFileBackSource;//파일 배경 소스 추가 필드
}
