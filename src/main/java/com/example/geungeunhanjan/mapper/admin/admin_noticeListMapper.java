package com.example.geungeunhanjan.mapper.admin;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface admin_noticeListMapper {
    //검색 결과 조회
    List<NoticePageDTO> adminSelectNotice(Map<String, Object> paramMap);
}
