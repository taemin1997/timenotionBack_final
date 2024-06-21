package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.board.KeywordVO;
import com.example.geungeunhanjan.service.board.BoardService;
import com.example.geungeunhanjan.service.board.KeywordService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EveryCycleApi {

    private final BoardService boardService;
    private final KeywordService keywordService;

    @GetMapping("/everyLife/{boardLifeCycle}")
    public List<BoardDTO> lifeCycle(@PathVariable("boardLifeCycle") String boardLifeCycle){
        return boardService.everyLifeCycle(boardLifeCycle);
    }

    @GetMapping("/everyLife/search")
    public List<BoardDTO> searchEveryLife(@RequestParam("keyword") String keyword, KeywordVO keywordVO) {
        keywordVO.setKeywordContent(keyword);
        keywordService.keywordInsert(keywordVO);

        return boardService.everySearchBoards(keyword);
    }

//    @GetMapping("/everyLife/viewsDescending")
//    public List<BoardDTO> everyViewsDescending(String boardViewCount) {
//        return boardService.everyViewsDescending(boardViewCount);
//    }


    @GetMapping("/myLife/{boardLifeCycle}")
public List<BoardVO> mylifeCycle(@PathVariable("boardLifeCycle") String boardLifeCycle, HttpSession session) {
    Long uniId = (Long) session.getAttribute("uniId");
    System.out.println("Session uniId: " + uniId);
    List<BoardVO> boardList = boardService.selectLifeCycle(boardLifeCycle, uniId);
    System.out.println("Response data: " + boardList); // 로그에 데이터 출력
    return boardList;
}


}
