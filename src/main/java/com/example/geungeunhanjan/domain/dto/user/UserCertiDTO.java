package com.example.geungeunhanjan.domain.dto.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserCertiDTO {
    private String userPhone;
    private String userEmail;
}
