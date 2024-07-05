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
}
