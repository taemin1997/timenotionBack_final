package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.board.ReportListDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.ReportVO;
import com.example.geungeunhanjan.mapper.admin.admin_reportMapper;
import com.example.geungeunhanjan.mapper.lifes.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_reportServiceImpl implements admin_reportService{
    private final admin_reportMapper reportMapper;
    private final ReportMapper reportOriginMapper;

    // 신고 목록 + 페이징
    @Override
    public List<ReportListDTO> reportPagingList(Criteria criteria) {
        return reportMapper.selectPageReportList(criteria);
    }

    @Override
    public int reportTotalCount() {
        return reportMapper.reportTotal();
    }


    // 신고 관리 (신고 삭제)
    @Override
    public void managementReport(Long commentId) {
        ReportVO reportVO = new ReportVO();
        reportVO.setCommentId(commentId);
        // 이건 조회용
//        reportOriginMapper.selectReportByCommentId(commentId);

        // 신고횟수가 3이상이면 삭제처리
            reportOriginMapper.deleteComment(commentId);
            reportOriginMapper.deleteReport(commentId);


    }

}
