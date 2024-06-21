package com.example.geungeunhanjan.mapper.lifes;

import com.example.geungeunhanjan.domain.vo.board.ReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface ReportMapper {
    void insertReport(ReportVO reportVO);

}
