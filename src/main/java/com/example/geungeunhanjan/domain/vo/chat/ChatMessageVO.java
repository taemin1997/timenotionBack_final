package com.example.geungeunhanjan.domain.vo.chat;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class ChatMessageVO {
    private long messageId;
    private long roomId;
    private long senderId;
    private long receiverId;
    private String messageContent;
    private LocalDateTime sendAt;
}
