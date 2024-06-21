package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import com.example.geungeunhanjan.domain.vo.file.UserFileVO;
import com.example.geungeunhanjan.service.MyPageService;
import com.example.geungeunhanjan.service.board.BoardFileService;
import com.example.geungeunhanjan.service.board.BoardService;
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


    // 프사 / 배사 목록을 가져오는 메소드 - everyLife
    @GetMapping("/v1/everyLife/{uniId}/files")
    public List<BoardDTO> getProfileEveryLife(@PathVariable("uniId") Long uniId) {
        System.out.println(uniId + "ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ");
        return boardService.getProfile(uniId);
    }

}
