package com.example.geungeunhanjan.mapper.lifes;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserInfoDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserUpdateDTO;
import com.example.geungeunhanjan.domain.dto.board.LikeDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {
    // 1. 좋아요 목록 select
    List<LikeDTO>selectMyLike(Long userId);
    // 페이징
    List<LikeDTO> selectPageMyLike(@Param("criteria") Criteria criteria, @Param("userId") Long userId);
    int myLikeTotal(Long userId);
    // 2. 내가 쓴 댓글 목록 select
    List<CommentDTO> selectMyComment(Long userId);
    //페이징
    List<CommentDTO> selectPageMyComment(@Param("criteria") Criteria criteria, @Param("userId") Long userId);
    int myCommentTotal(Long userId);
    // 3. 파일

    // 4. 회원정보 수정
    // 4-1. 프사 / 배사 파일 !!
    void insertFileById(UserFileVO userFileVO);
    UserFileVO selectFileById(Long userId);
    // 4-2 정보 업데이트 !
    void updateTwo(LifeUserUpdateDTO lifeUserUpdateDTO);
    void mergeToUser(Long userId);
    void mergeToKakao(Long userId);

    // 5. 회원정보 전체 불러오기
    LifeUserInfoDTO selectAllInfo (Long userId);

    // 6. 마이페이지 페이징 - 윤근님꺼
    List<BoardVO> selectMypagePaging(@Param("criteria") Criteria criteria, @Param("userId") Long userId);
    int selectMypageTotalCount(Long userId);

    // 7. 순서대로 팔로워 / 팔로잉 수
    int countFollower(Long userId);
    int countFollowing(Long userId);

}
