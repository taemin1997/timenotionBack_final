package com.example.geungeunhanjan.service.admin;

import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import com.example.geungeunhanjan.mapper.admin.admin_inquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class admin_inquiryServiceImpl implements admin_inquiryService{
    private final admin_inquiryMapper adminInquiryMapper;

    @Override
    public List<InquiryPagingDTO> selectAdminInquiryPage(InquiryCriteria inquiryCriteria) {
        return adminInquiryMapper.selectAdminInquiryPage(inquiryCriteria);
    }

    @Override
    public List<InquiryPagingDTO> selectAdminInquiryPage(Map<String, Object> paramMap) {
        return adminInquiryMapper.selectAdminInquiryPage(paramMap);
    }

    @Override
    public int selectAdminInquiryTotal() {
        return adminInquiryMapper.selectAdminInquiryTotal();
    }

    @Override
    public InquiryDTO selectAdminInquiryDetail(Long inquiryId) {
        return adminInquiryMapper.selectAdminInquiryDetail(inquiryId);
    }

    @Override
    public void writeAdminResponse(String inquiryResponse, Long inquiryId) {
        adminInquiryMapper.writeAdminResponse(inquiryResponse, inquiryId);
    }

    @Override
    public void removeInquiry(Long inquiryId) {
        adminInquiryMapper.deleteInquiry(inquiryId);
    }
}
