package com.example.geungeunhanjan.mapper.community;


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryWriteDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InquiryMapper {

    // 문의 리스트
    List<InquiryDTO> selectInquiryAll();

    // 문의 상세 id별로
    InquiryDTO selectInquiryDetail(Long inquiryId);

    // 문의 작성
    void inquiryWrite(InquiryWriteDTO inquiryWriteDTO);

    // 문의한 사람 닉네임
    String userNickNamebyInquiryId(Long inquiryId);

    // 문의 삭제
    void inquiryDelete(@Param("inquiryId") Long inquiryId,@Param("userId") Long userId);

    List<InquiryPagingDTO> selectAllInquiryPage(InquiryCriteria inquiryCriteria);

    int selectInquiryTotal();

    InquiryDTO selectUserIdByInquiryId(Long inquiryId);
    
}