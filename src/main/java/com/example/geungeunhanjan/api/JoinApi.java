package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class JoinApi {

    private final UserService userService;

    @PostMapping("/api/checkEmail")
    public Map<String, Boolean> checkEmailDuplicate(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String result = userService.emailDuplicateCheck(email);
        boolean exists = result != null;
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return response;
    }

    @PostMapping("/api/checkNickname")
    public Map<String, Boolean> checkNicknameDuplicate(@RequestBody Map<String, String> request) {
        String nickname = request.get("nickname");
        String result = userService.nicknameDuplicateCheck(nickname);
        boolean exists = result != null;
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return response;
    }

    @PostMapping("/api/checkPhone")
    public Map<String, Boolean> checkPhoneDuplicate(@RequestBody Map<String, String> request) {
        String phone = request.get("phone");
        String result = userService.phoneDuplicateCheck(phone);
        boolean exists = result != null;
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return response;
    }
}
