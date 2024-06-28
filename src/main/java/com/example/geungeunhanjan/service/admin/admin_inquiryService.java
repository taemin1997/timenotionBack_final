package com.example.geungeunhanjan.service.admin;


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

public interface admin_inquiryService {
    List<InquiryPagingDTO> selectAdminInquiryPage(InquiryCriteria inquiryCriteria);

    int selectAdminInquiryTotal();

    InquiryDTO selectAdminInquiryDetail(Long inquiryId);

    void writeAdminResponse(String inquiryResponse, Long inquiryId);
}
