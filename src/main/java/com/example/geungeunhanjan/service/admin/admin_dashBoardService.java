package com.example.geungeunhanjan.service.admin;

import java.sql.Date;

public interface admin_dashBoardService {
    // 총 회원 수 조회
    int getTotalMemberCount();
    // 오늘 날짜 조회
    Date getTodayDate();
    // 오늘 들어온 신고 횟수
    int countReportsToday();
    // 오늘 들어온 문의 횟수
    int countInquiryToday();
}
