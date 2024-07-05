package com.example.geungeunhanjan.domain.dto.chat;

import lombok.Data;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Data
public class ChatMessageDTO {
    private Long messageId;
    private Long roomId;
    private Long senderId;
    private Long receiverId;
    private String messageContent;
    private Timestamp sentAt;
    private String receiverNickname;
    private String receiverProfileSource;
    private String receiverProfileName;
    private String senderNickname;
    private String senderProfileSource;
    private String senderProfileName;


    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("roomId", roomId);
        map.put("senderId", senderId);
        map.put("receiverId", receiverId);
        map.put("messageContent", messageContent);
        return map;
    }
}
