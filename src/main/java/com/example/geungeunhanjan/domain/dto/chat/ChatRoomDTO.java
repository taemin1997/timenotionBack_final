package com.example.geungeunhanjan.domain.dto.chat;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class ChatRoomDTO {
    private long roomId;
    private long senderId;
    private long receiverId;
    private String receiverNickname;
    private String senderNickname;
    private LocalDateTime lastMessageSentAt;

    // 사진
    private String senderProfileSource;
    private String senderProfileName;
    private String senderProfileUuid;
    private String receiverProfileSource;
    private String receiverProfileName;
    private String receiverProfileUuid;
}
