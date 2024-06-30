package com.example.geungeunhanjan.mapper.lifes;

import com.example.geungeunhanjan.domain.vo.board.ReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface ReportMapper {
    // 신고 추가
    void insertReport(ReportVO reportVO);

    // 신고 count + 1
    int incReportCnt(ReportVO reportVO);

    // 신고 조회
    ReportVO selectReportByCommentId(Long commentId);
}
