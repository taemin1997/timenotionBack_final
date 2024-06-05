package com.example.geungeunhanjan.service.user;

import com.example.geungeunhanjan.domain.dto.user.UserSessionDTO;
import com.example.geungeunhanjan.domain.vo.user.UniVO;
import com.example.geungeunhanjan.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface UserService {

    // main 4칸짜리 게시물 닉네임알아내기
    String mainBoardByViewsNickname(long boardId);
    // 일반 로그인
    Long userLogin(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    // 일반유저의 다음 시퀀스
    Long getUserSeqNext();

    // 일반유저의 현재 시퀀스
    Long getUserSeqCurr();

    // uni의 현재 시퀀스
    Long getUniSeq();

    // 일반 회원 회원가입
    void userJoin(UserVO userVO);

    // 일반회원 회원가입인데 uni_id 넣어주기
    void userUniJoin(UniVO uniVO);

    // uni_id 받아와서 유저 닉네임 반환
    String selectUserNickname(Long uniId);

    // 모든 유저의 uni_id 반환
    Long findUniIdByUserIdOrKakaoId(@Param("userId") long userId, @Param("kakaoId") long kakaoId);

    UserSessionDTO uniUserIdNickname(Long uniId);

    UserSessionDTO uniKakaoIdNickName(String providerId);
}
