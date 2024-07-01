package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.board.ReportListDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.mapper.admin.admin_reportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_reportServiceImpl implements admin_reportService{
    private final admin_reportMapper reportMapper;

    // 신고 목록 + 페이징
    @Override
    public List<ReportListDTO> reportPagingList(Criteria criteria) {
        return reportMapper.selectPageReportList(criteria);
    }

    @Override
    public int reportTotalCount() {
        return reportMapper.reportTotal();
    }
}
