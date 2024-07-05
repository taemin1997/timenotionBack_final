package com.example.geungeunhanjan.mapper.admin;

import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.community.MemberDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface admin_memberListMapper {
    //검색 결과 조회
    List<MemberDTO> adminSelectMember(Map<String,Object> paramMap);
    //페이징 처리
    List<MemberDTO> selectAllPageMember(NoticeCriteria noticeCriteria);
    //회원 수 조회
    int selectTotalMember();
    //유저 상태 변경하기 (일반 , 정지 , 탈퇴)
    void updateStatusGeneral(long uniId);
    void updateStatusSuspension(long uniId);
    void updateStatuswithdrawal(long uniId);
    //검색 리스트 개수
    int countSearchKeyword(String keyword);
}
