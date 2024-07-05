package com.example.geungeunhanjan.mapper.chat;

import com.example.geungeunhanjan.domain.dto.chat.ChatMessageDTO;
import com.example.geungeunhanjan.domain.dto.chat.ChatRoomDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChatMapper {

    void createChatRoom(Map<String, Object> chatRoom);

    void insertChatMessage(Map<String, Object> chatMessage);

    List<ChatMessageDTO> getMessagesByRoomId(Long roomId);

    List<ChatRoomDTO> getChatRoomsByUserId(Long uniId);

    int checkChatRoomExist(Map<String, Object> uniMap);

    Long getExistingChatRoomId(Map<String, Object> uniMap);

    ChatRoomDTO getChatRoomsByRoomId(Long roomId);

}
