package com.example.geungeunhanjan.service.community;

import com.example.geungeunhanjan.domain.dto.community.InquiryDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryPagingDTO;
import com.example.geungeunhanjan.domain.dto.community.InquiryWriteDTO;
import com.example.geungeunhanjan.domain.dto.inquiryPage.InquiryCriteria;
import com.example.geungeunhanjan.mapper.community.InquiryMapper;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class InquiryServiceImlpe implements InquiryService {

    //주입
    private  final InquiryMapper inquiryMapper;


    // 문의 전부 다 뿌려주게 하기
    @Override
    public List<InquiryDTO> selectInquiryAll() {
        return inquiryMapper.selectInquiryAll();
    }

    // 각 id별 문의
    @Override
    public InquiryDTO selectInquiryDetail(Long inquiryId) {
        return inquiryMapper.selectInquiryDetail(inquiryId);
    }

    // 문의 닉네임
    @Override
    public String userNickNamebyInquiryId(Long inquiryId) {
        return inquiryMapper.userNickNamebyInquiryId(inquiryId);
    }

    // 문의 삭제
    @Override
    public void inquiryDelete(@Param("inquiryId") Long inquiryId, @Param("userId") Long userId) {
        inquiryMapper.inquiryDelete(inquiryId, userId);
    }

    // 문의 작성
    @Override
    public void inquiryWrite(InquiryWriteDTO inquiryWriteDTO) {
        inquiryMapper.inquiryWrite(inquiryWriteDTO);
    }

    // 문의 페이징
    @Override
    public List<InquiryPagingDTO> selectAllInquiryPage(InquiryCriteria inquiryCriteria){
        return inquiryMapper.selectAllInquiryPage(inquiryCriteria);
    }

    // 문의 총 갯수
    @Override
    public int selectInquiryTotal () {
        return inquiryMapper.selectInquiryTotal();
    }

    @Override
    public InquiryDTO selectUserIdByInquiryId(Long inquiryId) {
        return inquiryMapper.selectUserIdByInquiryId(inquiryId);
    }
}