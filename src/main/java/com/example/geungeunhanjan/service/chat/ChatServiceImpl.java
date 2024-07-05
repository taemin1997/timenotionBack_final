package com.example.geungeunhanjan.service.chat;

import com.example.geungeunhanjan.domain.dto.chat.ChatMessageDTO;
import com.example.geungeunhanjan.domain.dto.chat.ChatRoomDTO;
import com.example.geungeunhanjan.mapper.chat.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMapper chatMapper;

    @Override
    public void createChatRoom(Map<String, Object> chatRoom) {
        chatMapper.createChatRoom(chatRoom);
    }

    @Override
    public void insertChatMessage(Map<String, Object> chatMessage) {
        chatMapper.insertChatMessage(chatMessage);
    }

    @Override
    public List<ChatMessageDTO> getMessagesByRoomId(Long roomId) {
        return chatMapper.getMessagesByRoomId(roomId);
    }

    @Override
    public List<ChatRoomDTO> getChatRoomsByUserId(Long uniId) {
        return chatMapper.getChatRoomsByUserId(uniId);
    }

    @Override
    public int checkChatRoomExist(Map<String, Object> uniMap) {
        return chatMapper.checkChatRoomExist(uniMap);
    }

    @Override
    public Long checkOrCreateRoom(Long senderId, Long receiverId) {
        Map<String, Object> rooms = new HashMap<>();
        rooms.put("senderId", senderId);
        rooms.put("receiverId", receiverId);

        int count = chatMapper.checkChatRoomExist(rooms);
        if (count > 0) {
            return chatMapper.getExistingChatRoomId(rooms);
        } else {
            chatMapper.createChatRoom(rooms);
            return (Long) rooms.get("roomId");
        }
    }

    @Override
    public ChatRoomDTO getChatRoomsByRoomId(Long roomId) {
        return chatMapper.getChatRoomsByRoomId(roomId);
    }
}
