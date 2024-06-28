package com.example.geungeunhanjan.domain.dto.FollowPage;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FollowFileList {
    // 제작자 : 윤담
    // 목적 : 팔로워 / 팔로잉 목록 불러오기 위함
    private Long followId;
    private String nickname;
    private String userFileProfileName;
    private String userFileProfileSource;
    private String userFileProfileUuid;

}
