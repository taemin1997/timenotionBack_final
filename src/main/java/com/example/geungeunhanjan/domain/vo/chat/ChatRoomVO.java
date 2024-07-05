package com.example.geungeunhanjan.domain.vo.chat;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ChatRoomVO {
    private long roomId;
    private long senderId;
    private long receiverId;
}
