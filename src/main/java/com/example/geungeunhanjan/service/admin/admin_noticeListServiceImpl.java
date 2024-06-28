package com.example.geungeunhanjan.service.admin;


import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_noticeListServiceImpl implements admin_noticeListService{
    private final com.example.geungeunhanjan.mapper.admin.admin_noticeListMapper admin_noticeListMapper;

    @Override
    public List<NoticePageDTO> adminSelectNotice(Map<String, Object> paramMap) {
        return admin_noticeListMapper.adminSelectNotice(paramMap);
    }
}

