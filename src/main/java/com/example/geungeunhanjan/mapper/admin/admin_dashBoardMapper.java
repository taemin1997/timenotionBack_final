package com.example.geungeunhanjan.mapper.admin;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;

@Mapper
public interface admin_dashBoardMapper {
    // 총 회원 수 조회
    int getTotalMemberCount();
    // 오늘 날짜 조회
    Date getTodayDate();
    // 오늘 들어온 신고 횟수
    int countReportsToday();
    // 오늘 들어온 문의 횟수
    int countInquiryToday();
}
