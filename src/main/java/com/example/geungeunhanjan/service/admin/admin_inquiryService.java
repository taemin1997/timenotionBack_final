package com.example.geungeunhanjan.service.admin;


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface admin_inquiryService {
    List<InquiryPagingDTO> selectAdminInquiryPage(InquiryCriteria inquiryCriteria);

    List<InquiryPagingDTO> selectAdminInquiryPage(Map<String, Object> paramMap);

    int selectAdminInquiryTotal();

    InquiryDTO selectAdminInquiryDetail(Long inquiryId);

    void writeAdminResponse(String inquiryResponse, Long inquiryId);

    void removeInquiry(Long inquiryId);
}
