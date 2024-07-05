package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.mapper.admin.admin_dashBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_dashBoardServiceImpl implements admin_dashBoardService{

    private final admin_dashBoardMapper adminDashBoardMapper;

    // 총 회원 수 조회
    @Override
    public int getTotalMemberCount() {
        return adminDashBoardMapper.getTotalMemberCount();
    }
    // 오늘 날짜 조회
    @Override
    public Date getTodayDate() {
        return adminDashBoardMapper.getTodayDate();
    }
    // 오늘 들어온 신고 횟수
    @Override
    public int countReportsToday() {
        return adminDashBoardMapper.countReportsToday();
    }

    @Override
    public int countInquiryToday() {
        return adminDashBoardMapper.countInquiryToday();
    }
}
