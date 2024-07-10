package com.example.geungeunhanjan.mapper.chat;

import com.example.geungeunhanjan.domain.dto.chat.ChatMessageDTO;
import com.example.geungeunhanjan.domain.dto.chat.ChatRoomDTO;
import com.example.geungeunhanjan.domain.vo.chat.ChatMessageVO;
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

    ChatRoomDTO getChatIInfoByRoomId(Long roomId); // 프사 uuid까지 가져오는애

    ChatMessageVO getMessageMostRecent(Long roomId); //  최신순 대화 1개만 가져옴


}
