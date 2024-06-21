package com.example.geungeunhanjan.domain.vo.file;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardFileVO {
    private Long boardFileId;
    private String boardFileName;
    private String boardFileSourceName;
    private String boardFileUuid;
    private Long boardId;
}
