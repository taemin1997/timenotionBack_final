package com.example.geungeunhanjan.service.community;



import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.vo.community.NoticeVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {

    //문의의 다음 시퀀스
    Long getNoticeSeqNext();

    //공지 리스트 조회하기
    List<NoticeDTO> selectNoticeAll();

    // 공지 리스트 클릭시 상세 페이지 조회하기
    NoticeDTO selectNoticeDetail(Long noticeId);

    //공지 작성하기
    void insertNotice(NoticeVO noticeVO);

    //공지 삭제하기
    void deleteNotice(Long noticeId);

    //페이징 처리
    List<NoticePageDTO> selectAllPageNotice(NoticeCriteria noticeCriteria);

    //3개 컬럼만 가지고오는 메소드
    List<NoticePageDTO> selectAllNotice();

    //페이지 총 수 조회하기
    int selectTotalNotice();
}
