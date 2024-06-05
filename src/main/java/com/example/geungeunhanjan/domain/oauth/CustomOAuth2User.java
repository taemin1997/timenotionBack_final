package com.example.geungeunhanjan.domain.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {
    private OAuth2User oAuth2User;
    private String name;
    private String profilePic;
    private String providerId;

    public CustomOAuth2User(OAuth2User oAuth2User, String name, String profilePic, String providerId){
        this.oAuth2User = oAuth2User;
        this.name = name;
        this.profilePic = profilePic;
        this.providerId = providerId;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oAuth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getProviderId(){
        return providerId;
    }
}