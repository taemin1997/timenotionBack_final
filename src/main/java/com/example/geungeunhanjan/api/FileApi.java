package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.FollowPage.FollowFileList;
import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.board.BoardMainDTO;
import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.board.BoardFileService;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.lifes.FollowService;
import com.nimbusds.jose.shaded.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileApi {
    public final BoardFileService boardFileService;
    public final BoardService boardService;
    public final MyPageService myPageService;
    public final FollowService followService;

    @Value("C:/upload/")
    private String fileDir;

    @GetMapping("/v1/boards/{boardId}/files")
    public List<BoardFileVO> fileList(@PathVariable("boardId") Long boardId){
        return  boardFileService.findFileList(boardId);
    }

    @GetMapping("/v1/files")
    public byte[] dislay(String fileName) throws IOException {
        File file = new File(fileDir, fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

    /* 프사 / 배사 목록을 가져오는 메소드 */
    @GetMapping("/v1/mylife/{uniId}/files")
    public UserFileVO getProfileBackFile(@PathVariable("uniId") Long uniId){
        return myPageService.getProfileBackFile(uniId);
    }

    /* 프사 / 배사 파일 자체를 가져오는 메소드*/
    @GetMapping("/v1/user-files")
    public byte[] getProfileBackFile(String fileName) throws IOException {
        File profileBack = new File(fileDir, fileName);
        return FileCopyUtils.copyToByteArray(profileBack);
    }


    // 프사 가져오는 메소드 - everyLife
    @GetMapping("/v1/everyLife/{uniId}/files")
    public List<BoardDTO> getProfileEveryLife(@PathVariable("uniId") Long uniId) {
        System.out.println(uniId + "ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ");
        return boardService.getProfile(uniId);
    }
    // 프사 가져오는 메소드 - 팔로워 목록
    @GetMapping("/v1/followerImg/{followerId}/files")
    public List<FollowFileList> getFollowerProfile(@PathVariable("followerId") Long followerId) {
        System.out.println(followerId + "<--- 팔로워 아이디 ");
        return followService.getFollowFileList(followerId);
    }
    // 프사 가져오는 메소드 - 팔로잉 목록
    @GetMapping("/v1/followingImg/{followingId}/files")
    public List<FollowFileList> getFollowingProfile(@PathVariable("followingId") Long followingId) {
        System.out.println(followingId + "<--- 팔로잉 아이디 ");
        return followService.getFollowFileList(followingId);
    }


    /* 메인 페이지 -----------------------------------------------------  */
    // 메인페이지 왼쪽배너사진 가져오는 메소드
    @GetMapping("/v1/leftBanner/{boardId}/files")
    public BoardMainDTO getLeftBanner(@PathVariable("boardId") Long boardId) {
        return boardService.mainLeftBannerSelect();
    }
    // 메인페이지 왼쪽배너 profile사진 가져오는 메소드
    @GetMapping("/v1/leftBanner/profile/{userId}/files")
    public BoardMainDTO getLeftBannerProfile(@PathVariable("userId") Long userId) {
        BoardMainDTO bs = boardService.mainLeftBannerSelect();
        return boardService.mainLeftBannerSelect();
    }

    // 메인페이지 오른쪽배너사진 가져오는 메소드
    @GetMapping("/v1/rightBanner/{boardId}/files")
    public List<BoardFileVO> getRightBanner(@PathVariable("boardId") Long boardId) {
        System.out.println(boardId + "<--- 오른쪽 배너 보드 아이디 ");
        BoardFileVO file = new BoardFileVO();
        file.setBoardId(boardId);
        System.out.println("오른쪽 배너 파일 이름 : " +file.getBoardFileName()+file.getBoardFileSourceName());
        return boardService.getBoardFile(boardId);
    }
    // 메인페이지 오른쪽배너 profile사진 가져오는 메소드
    @GetMapping("/v1/rightBanner/profile/{userId}/files")
    public List<BoardDTO> getRightBannerProfile(@PathVariable("userId") Long userId) {
        System.out.println(userId + "<--- 오른쪽 배너 유저 아이디 ");

        List<BoardMainDTO> rightBannerList = boardService.mainRightBannerSelect();

        // 각 항목의 userId 값을 비교해봅시다.
        for (BoardMainDTO dto : rightBannerList) {
            System.out.println("게시물의 userId: " + dto.getUserId());
            System.out.println("프로필사진 이름 : " + dto.getUserFileProfileName());
        }

//        System.out.println("RRR -- 프로필사진 이름 : " + bs.getUserFileProfileName());
//        System.out.println("RRR -- 프로필사진 이름 22 : " + bs2.getUserFileProfileName());
//        System.out.println("RRR -- 닉네임임임 : " + bs.getUserNickname());
//        System.out.println("RRR -- 프로필사진 이름 : " + bs.getUserFileProfileName());
//        System.out.println("RRR -- 닉네임임임 22 : " + bs2.getUserNickname());
        return boardService.getProfile(userId);
    }



}
