package com.example.geungeunhanjan.service.user;

import com.example.geungeunhanjan.domain.dto.user.UserSessionDTO;
import com.example.geungeunhanjan.domain.vo.user.UniVO;
import com.example.geungeunhanjan.domain.vo.user.UserVO;
import com.example.geungeunhanjan.mapper.board.BoardMapper;
import com.example.geungeunhanjan.mapper.user.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImple implements UserService{
    private final UserMapper userMapper;
    private final BoardMapper boardMapper;

    public UserServiceImple(UserMapper userMapper, BoardMapper boardMapper) {
        this.userMapper = userMapper;
        this.boardMapper = boardMapper;
    }

    // main 4칸짜리 게시물 닉네임알아내기
    @Override
    public String mainBoardByViewsNickname(long boardId) {
        return userMapper.mainBoardByViewsNickname(boardId);
    }

    // 일반 로그인
    @Override
    public Long userLogin(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword) {
        return userMapper.userLogin(userEmail, userPassword);
    }

    // 일반유저의 다음 시퀀스
    @Override
    public Long getUserSeqNext() {
        return userMapper.getUserSeqNext();
    }

    // 일반유저의 현재 시퀀스
    @Override
    public Long getUserSeqCurr() {
        return userMapper.getUserSeqCurr();
    }

    // uni의 현재 시퀀스
    @Override
    public Long getUniSeq() {
        return userMapper.getUniSeq();
    }

    // 일반 회원 회원가입
    @Override
    public void userJoin(UserVO userVO) {
//        long boardId = userMapper.getUserSeq();
//        userVO.setUserId(boardId);
        userMapper.userJoin(userVO);
    }

    // 일반회원 회원가입인데 uni_id 넣어주기
    @Override
    public void userUniJoin(UniVO uniVO) {
        userMapper.userUniJoin(uniVO);
    }

    // uni_id 받아와서 유저 닉네임 반환
    @Override
    public String selectUserNickname(Long uniId) {
        return userMapper.selectUserNickname(uniId);
    }

    // 모든 유저의 uni_id 반환
    @Override
    public Long findUniIdByUserIdOrKakaoId(long userId, long kakaoId) {
        return userMapper.findUniIdByUserIdOrKakaoId(userId, kakaoId);
    }

    @Override
    public UserSessionDTO uniUserIdNickname(Long uniId) {
        return userMapper.uniUserIdNickname(uniId);
    }

    @Override
    public UserSessionDTO uniKakaoIdNickName(String providerId) {
        return userMapper.uniKakaoIdNickName(providerId);
    }
}


