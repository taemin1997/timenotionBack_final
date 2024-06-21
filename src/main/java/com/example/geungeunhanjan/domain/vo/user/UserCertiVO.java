package com.example.geungeunhanjan.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserCertiVO {
    private String userPhone;
    private String userEmail;
    private String certiNumber;
}
