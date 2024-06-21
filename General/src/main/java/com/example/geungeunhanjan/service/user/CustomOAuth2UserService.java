package com.example.geungeunhanjan.service.user;

import com.example.geungeunhanjan.domain.oauth.CustomOAuth2User;
import com.example.geungeunhanjan.domain.vo.user.KakaoVO;
import com.example.geungeunhanjan.domain.vo.user.UniVO;
import com.example.geungeunhanjan.mapper.user.KakaoUserMapper;
import com.example.geungeunhanjan.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final KakaoUserMapper kakaoUserMapper;
    private final UserService userService;
    private final UserMapper userMapper;



    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // OAuth2로부터 받은 사용자 정보
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // 카카오는 attributes 내에 kakao_account 객체에 사용자 정보를 담고 있음
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");

        // 프로필 정보는 kakao_account 내의 profile 객체에 있음
        Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
        String name = (String) profile.get("nickname");
        String profilePic = (String) profile.get("profile_image_url");

        // 카카오의 경우 ID는 최상위 attributes 객체의 id 필드에 있음
        String providerId = attributes.get("id").toString();

        // zoneddatetime? utc? instant
//        LocalDateTime conn = LocalDateTime.parse(attributes.get("connected_at").toString());
//        user.setCreateAt(conn);
//        user.setUpdateAt(conn);

        // UsersVO 객체에 정보 설정
        KakaoVO user = new KakaoVO();
        user.setProviderId(providerId); // OAuth2 제공자에서의 사용자 고유 ID
        user.setName(name);
        user.setProvider("kakao");
        user.setProfilePic(profilePic);
        user.setProvider(userRequest.getClientRegistration().getRegistrationId());
        // OAuth2 제공자의 이름 (예: "google")

        // DB에 사용자 정보 저장 또는 업데이트
        KakaoVO existingUser = kakaoUserMapper.findByProviderId(providerId);
        if (existingUser == null) {
            // 사용자가 새로운 경우, DB에 저장
            System.out.println(user);
            kakaoUserMapper.insertUser(user);
            UniVO uniVO = new UniVO();
            uniVO.setKakaoId(user.getKakaoId());
            userMapper.userUniJoin(uniVO);
        } else {
            // 이미 존재하는 사용자인 경우, 필요한 정보 업데이트
            existingUser.setName(name); // 예시: 이름 정보 업데이트
            existingUser.setProfilePic(profilePic); // 예시: 프로필 사진 정보 업데이트


            kakaoUserMapper.updateUser(existingUser);
        }

        System.out.println(oAuth2User);


//        return oAuth2User;
        return new CustomOAuth2User(oAuth2User, name, profilePic, providerId);
    }
}
