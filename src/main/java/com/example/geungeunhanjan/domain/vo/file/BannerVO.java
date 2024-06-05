package com.example.geungeunhanjan.domain.vo.file;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BannerVO {
    private Long bannerId;
    private String bannerName;
    private String bannerSource;
    private Long userId;
}
