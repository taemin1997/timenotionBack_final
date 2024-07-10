package com.example.geungeunhanjan.service.chat;

import com.example.geungeunhanjan.domain.dto.chat.ChatMessageDTO;
import com.example.geungeunhanjan.domain.dto.chat.ChatRoomDTO;
import com.example.geungeunhanjan.domain.vo.chat.ChatMessageVO;

import java.util.List;
import java.util.Map;

public interface ChatService {

    void createChatRoom(Map<String, Object> chatRoom);

    void insertChatMessage(Map<String, Object> chatMessage);

    List<ChatMessageDTO> getMessagesByRoomId(Long roomId);

    List<ChatRoomDTO> getChatRoomsByUserId(Long uniId);

    int checkChatRoomExist(Map<String, Object> uniMap);

    Long checkOrCreateRoom(Long senderId, Long receiverId);

    ChatRoomDTO getChatRoomsByRoomId(Long roomId);

    ChatRoomDTO getChatIInfoByRoomId(Long roomId);

    ChatMessageVO getMessageMostRecent(Long roomId);
}
