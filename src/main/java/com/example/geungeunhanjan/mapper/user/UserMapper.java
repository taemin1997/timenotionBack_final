package com.example.geungeunhanjan.mapper.user;

import com.example.geungeunhanjan.domain.dto.user.UserSessionDTO;
import com.example.geungeunhanjan.domain.vo.user.UniVO;
import com.example.geungeunhanjan.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    // 메인 4칸짜리 게시물 유저 닉네임
    String mainBoardByViewsNickname(long boardId);

    // 일반 로그인(바꿀 예정)
    Long userLogin(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

    // 일반유저 다음 seq
    Long getUserSeqNext();

    // 일반유저 현재 seq
    Long getUserSeqCurr();

    // 통합 유저 seq
    Long getUniSeq();

    // 일반 회원가입(바꿀예정)
    void userJoin(UserVO userVO);

    // 통합 유저 생성(바꿀예정)
    void userUniJoin(UniVO uniVO);

    // 모든 유저 닉네임
    String selectUserNickname(Long uniId);
    //
    // 통합 유저 id값
    Long findUniIdByUserIdOrKakaoId(@Param("userId") long userId, @Param("kakaoId") long kakaoId);

    UserSessionDTO uniUserIdNickname(Long uniId);

    UserSessionDTO uniKakaoIdNickName(String providerId);
}
