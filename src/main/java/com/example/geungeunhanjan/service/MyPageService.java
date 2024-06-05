package com.example.geungeunhanjan.service;

import com.example.geungeunhanjan.domain.dto.board.CommentDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserInfoDTO;
import com.example.geungeunhanjan.domain.dto.board.LifeUserUpdateDTO;
import com.example.geungeunhanjan.domain.dto.board.LikeDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.multi.MultiListUI;
import java.io.IOException;
import java.util.List;

public interface MyPageService {
    // 1. 내 좋아요 목록 select
    List<LikeDTO>selectMyLike(Long userId);
    // 페이징
    List<LikeDTO> findPageMyLike(Criteria criteria, Long userId);
    int myLikeTotal(Long userId);
    // 2. 내가 쓴 댓글 목록 select
    List<CommentDTO> selectMyComment(Long userId);
    //페이징
    List<CommentDTO> findPageMyComment(Criteria criteria, Long userId);
    int myCommentTotal(Long userId);

    // 4. 회원정보 수정
    // 4-1. 프사 / 배사 파일 !!
    void registProfileBackFile(UserFileVO userFileVO, List<MultipartFile> files) throws IOException;
    UserFileVO getProfileBackFile(Long userFileId);
    /* 4-2. 회원 텍스트 정보 수정*/
    void updateUserInfo(LifeUserInfoDTO lifeUserInfoDTO);
    /* 업데이트 3번째 06-04 */
    void totalUpdateInfo(LifeUserUpdateDTO lifeUserUpdateDTO, List<MultipartFile> files) throws IOException;

    /* 5. 회원 정보 셀렉트 */
    LifeUserInfoDTO selectAllInfo (Long userId);

    // 6. 마이페이지 페이징 - 윤근님꺼
    List<BoardVO> selectMypagePaging(Criteria criteria, Long userId);
    int myPageTotal(Long userId);

    // 7. 팔로워 / 팔로잉 수
    int countFollower(Long userId);
    int countFollowing(Long userId);
}
