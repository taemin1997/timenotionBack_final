package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.board.ReportListDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;

import java.util.List;

public interface admin_reportService {
    List<ReportListDTO> reportPagingList(Criteria criteria);
    int reportTotalCount();

    void managementReport(Long commentId);
}
