package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;

import java.util.List;
import java.util.Map;

public interface admin_noticeListService {
    //모두의 일대기 검색 결과
    List<NoticePageDTO> adminSelectNotice(Map<String, Object> paramMap);

}
