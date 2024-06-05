package com.example.geungeunhanjan.domain.vo.file;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserFileVO {
    private Long userFileId;
    private String userFileProfileName;
    private String userFileProfileSource;
    private String userFileProfileUuid;
    private String userFileBackName;
    private String userFileBackSource;
    private String userFileBackUuid;
    private Long userId;
    private Long uniId;
}
