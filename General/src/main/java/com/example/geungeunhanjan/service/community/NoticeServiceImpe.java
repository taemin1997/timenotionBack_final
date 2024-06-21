package com.example.geungeunhanjan.service.community;


import com.example.geungeunhanjan.domain.dto.NoticePage.NoticeCriteria;
import com.example.geungeunhanjan.domain.dto.community.NoticeDTO;
import com.example.geungeunhanjan.domain.dto.community.NoticePageDTO;
import com.example.geungeunhanjan.domain.vo.community.NoticeVO;
import com.example.geungeunhanjan.mapper.community.NoticeMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpe implements NoticeService {

    //의존성주입
    private final NoticeMapper noticeMapper;
    private final HttpSession httpSession;

    public NoticeServiceImpe(NoticeMapper noticeMapper, HttpSession httpSession) {
        this.noticeMapper = noticeMapper;
        this.httpSession = httpSession;
    }


    //문의 다음 시퀀스
    @Override
    public Long getNoticeSeqNext() {
        return  noticeMapper.getNoticeSeqNext();
    }

    //공지 리스트 조회하기
    @Override
    public List<NoticeDTO> selectNoticeAll() {
        return noticeMapper.selectNoticeAll();
    }
    // 공지 리스트 클릭시 상세 페이지 조회하기
    @Override
    public NoticeDTO selectNoticeDetail(Long noticeId) {
        return noticeMapper.selectNoticeDetail(noticeId);
    }

    //공지글 작성하기
    @Override
    public void insertNotice(NoticeVO noticeVO) {
        noticeMapper.insertNotice(noticeVO);
    }
    //공지글 삭제하기
    @Override
    public void deleteNotice(Long noticeId) {
        noticeMapper.deleteNotice(noticeId);
    }
    //페이징 처리
    @Override
    public List<NoticePageDTO> selectAllPageNotice(NoticeCriteria noticeCriteria) {
        return noticeMapper.selectAllPageNotice(noticeCriteria);
    }

    @Override
    public List<NoticePageDTO> selectAllNotice() {
        return noticeMapper.selectAllNotice();
    }

    @Override
    public int selectTotalNotice() {
        return noticeMapper.selectTotalNotice();
    }


}
