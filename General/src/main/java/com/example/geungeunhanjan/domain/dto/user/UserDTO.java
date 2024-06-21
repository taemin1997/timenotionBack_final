package com.example.geungeunhanjan.domain.dto.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class UserDTO {
    private Long uniId;
    private String nickname;
    private String email;
    private String about;
    private LocalDateTime birth;
    private String status;
}
