    package com.example.geungeunhanjan.domain.vo.board;

    import lombok.Data;
    import org.springframework.stereotype.Component;

    import java.time.LocalDateTime;


@Component
@Data
public class BoardVO {
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardPublic;
    private LocalDateTime boardCreatedDate;
    private LocalDateTime boardUpdatedDate;
    private int boardViewCount;
    private String boardLifeCycle;
    private int boardLikeCount;
    private int boardYear;
    private Long userId;


}

