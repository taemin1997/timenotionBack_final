package com.example.geungeunhanjan.mapper.user;

import com.example.geungeunhanjan.domain.vo.user.KakaoVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KakaoUserMapper {
    KakaoVO findByProviderId(String providerId);

    void insertUser(KakaoVO user);

    void updateUser(KakaoVO user);
}
