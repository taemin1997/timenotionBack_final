package com.example.geungeunhanjan.controller;


import com.example.geungeunhanjan.domain.dto.user.UserCertiDTO;
import com.example.geungeunhanjan.domain.vo.user.UserCertiVO;
import com.example.geungeunhanjan.service.user.UserService;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
@RequestMapping("/sms")
public class SmsController {

    final DefaultMessageService messageService;
    private final UserService userService;


    public SmsController(UserService userService) {
        this.userService = userService;
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize("NCSGY9IN3N5HP1QH", "Z9AX8RAHJXHZPQNCVXZFFCURP9U4YZZI", "https://api.coolsms.co.kr");
    }


    @PostMapping("/send-one")
    public ResponseEntity<?> sendOne(String phoneNum, String userEmail) {
        // 유저의 전화번호와 요청된 전화번호가 일치하는지 확인
        if (userService.selectEmail(userEmail).getUserPhone().equals(phoneNum)) {
            // 난수 생성
            String smsMessagePost = String.valueOf(randomNumberCreate());
            String msg = "타임노션 [" + smsMessagePost + "] 인증번호를 입력해주세요";

            Message message = new Message();
            message.setFrom("01040475420");
            message.setTo(phoneNum);
            message.setText(msg);

            SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));

            userService.insertOrUpdateCerti(userEmail, phoneNum, smsMessagePost);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid phone number or email");
        }
    }

    //난수 생성 메소드 (5자리)
    private int randomNumberCreate(){
        int min = 10000;
        int max = 99999;
        return (int)Math.floor(Math.random() * (max - min + 1)) + min;
    }

}
