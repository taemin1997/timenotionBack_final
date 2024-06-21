package com.example.geungeunhanjan.api;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InquiryApi {

    @GetMapping("/api/getUserInfo")
    public ResponseEntity<Long> getUserInfo(HttpSession session) {
        // HttpSession에서 사용자 정보를 가져오는 로직을 작성
        Long uniId = (Long) session.getAttribute("uniId");
        if (uniId == null) {
            // 사용자 정보가 없을 경우 예외 처리 또는 기본값 설정
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(uniId);
    }


}
