package com.example.geungeunhanjan.mapper.admin;

import com.example.geungeunhanjan.domain.dto.board.ReportListDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface admin_reportMapper {

    // 페이징 신고 목록 -- 아이디 따로 안받음
    List<ReportListDTO> selectPageReportList(@Param("criteria") Criteria criteria);
    int reportTotal();


}
