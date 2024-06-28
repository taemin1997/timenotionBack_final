package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.community.MemberDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_memberListServiceImpl implements admin_memberListService{
    private final com.example.geungeunhanjan.mapper.admin.admin_memberListMapper admin_memberListMapper;

    @Override
    public List<MemberDTO> adminSelectMember(Map<String, Object> paramMap) {
        return admin_memberListMapper.adminSelectMember(paramMap);
    }

    @Override
    public List<MemberDTO> selectAllPageMember(NoticeCriteria noticeCriteria) {
        return admin_memberListMapper.selectAllPageMember(noticeCriteria);
    }

    @Override
    public int selectTotalMember() {
        return admin_memberListMapper.selectTotalMember();
    }

    @Override
    public void updateStatusGeneral(long uniId) {
        admin_memberListMapper.updateStatusGeneral(uniId);
    }

    @Override
    public void updateStatusSuspension(long uniId) {
        admin_memberListMapper.updateStatusSuspension(uniId);
    }

    @Override
    public void updateStatuswithdrawal(long uniId) {
        admin_memberListMapper.updateStatuswithdrawal(uniId);
    }
}
