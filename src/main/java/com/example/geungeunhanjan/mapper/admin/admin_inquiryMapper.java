package com.example.geungeunhanjan.mapper.admin;

import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface admin_inquiryMapper {
    List<InquiryPagingDTO> selectAdminInquiryPage(InquiryCriteria inquiryCriteria);

    List<InquiryPagingDTO> selectAdminInquiryPage(Map<String, Object> paramMap);

    int selectAdminInquiryTotal();

    InquiryDTO selectAdminInquiryDetail(Long inquiryId);

    void writeAdminResponse(String inquiryResponse, Long inquiryId);

    void deleteInquiry(Long inquiryId);
}
