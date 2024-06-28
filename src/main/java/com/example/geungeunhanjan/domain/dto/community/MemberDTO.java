package com.example.geungeunhanjan.domain.dto.community;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Data
public class MemberDTO {
//    admin 폴더가 따로 없어서 일단 여기다 만듬
    private long uniId;
    private String nickname;
    private String name;
    private String email;
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date birth;
    private String status;

}
