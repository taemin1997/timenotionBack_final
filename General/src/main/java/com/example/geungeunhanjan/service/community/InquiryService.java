package com.example.geungeunhanjan.service.community;


import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryWriteDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryService {

    // 문의 내용 뿌려주기위한 거
    List<InquiryDTO> selectInquiryAll();

    // 각 id별 문의 상세
    InquiryDTO selectInquiryDetail(Long inquiryId);

    // 문의 작성자 닉네임
    String userNickNamebyInquiryId(Long inquiryId);

    // 문의 삭제
    void inquiryDelete(@Param("inquiryId") Long inquiryId, @Param("userId") Long userId);

    // 문의 작성
    void inquiryWrite(InquiryWriteDTO inquiryWriteDTO);

    // 문의 페이징
    List<InquiryPagingDTO> selectAllInquiryPage(InquiryCriteria inquiryCriteria);

    // 문의 총 갯수
    int selectInquiryTotal();

    InquiryDTO selectUserIdByInquiryId(Long inquiryId);

}