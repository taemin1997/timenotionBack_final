package com.example.geungeunhanjan.domain.dto.user;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class UserSessionDTO {
    private Long uniId;
    private String userNickname;
}
