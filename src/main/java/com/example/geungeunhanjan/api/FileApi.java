package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.vo.file.BoardFileVO;
import com.example.geungeunhanjan.service.board.BoardFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileApi {
    public final BoardFileService boardFileService;

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
}
