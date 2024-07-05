package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatApi {

    private final ChatService chatService;

    @GetMapping("/rooms")
    public long getChatRooms(@RequestParam long senderId, @RequestParam long receiverId) {
        Map<String, Object> rooms = new HashMap<>();
        rooms.put("senderId", senderId);
        rooms.put("receiverId", receiverId);
        return chatService.checkChatRoomExist(rooms);
    }
}
