package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.dto.board.KeywordDTO;
import com.example.geungeunhanjan.domain.dto.lifePage.Criteria;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.domain.vo.board.KeywordSearchCountVO;
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
    public List<BoardDTO> lifeCycle(@PathVariable("boardLifeCycle") String boardLifeCycle) {
        return boardService.everyLifeCycle(boardLifeCycle);
    }

    @GetMapping("/everyLife/search")
    public List<BoardDTO> searchEveryLife(@RequestParam("keyword") String keyword, KeywordVO keywordVO, KeywordDTO keywordDTO) {
        keywordService.keywordIncreament(keywordVO, keyword);
        return boardService.everySearchBoards(keyword);
    }

    @GetMapping("/everyLife/orderBy/{orderBy}")
    public List<BoardDTO> orderByEveryLife(@PathVariable("orderBy") String orderBy, Criteria criteria) {
        List<BoardDTO> orderByEveryLife;
        criteria.setAmount(12);
        switch (orderBy) {
            case "views":
                orderByEveryLife = boardService.getSelectEveryView(criteria);
                break;
            case "popularity":
                orderByEveryLife = boardService.getSelectEveryPopular(criteria);
                break;
            case "latest":
            default:
                orderByEveryLife = boardService.getSelectEveryLatest(criteria);
                break;
        }
        return orderByEveryLife;
    }

//    @GetMapping("/myLife/{boardLifeCycle}")
//    public List<BoardVO> mylifeCycle(@PathVariable("boardLifeCycle") String boardLifeCycle, HttpSession session) {
//        Long uniId = (Long) session.getAttribute("uniId");
//        System.out.println("Session uniId: " + uniId);
//        List<BoardVO> boardList = boardService.selectLifeCycle(boardLifeCycle, uniId);
//        System.out.println("Response data: " + boardList); // 로그에 데이터 출력
//        return boardList;
//    }


}
