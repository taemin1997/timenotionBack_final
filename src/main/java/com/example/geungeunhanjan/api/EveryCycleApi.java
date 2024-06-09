package com.example.geungeunhanjan.api;

import com.example.geungeunhanjan.domain.dto.board.BoardDTO;
import com.example.geungeunhanjan.domain.vo.board.BoardVO;
import com.example.geungeunhanjan.service.board.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EveryCycleApi {

    private final BoardService boardService;

    @GetMapping("/everyLife/{boardLifeCycle}")
    public List<BoardDTO> lifeCycle(@PathVariable("boardLifeCycle") String boardLifeCycle){
        return boardService.everyLifeCycle(boardLifeCycle);
    }

//    @GetMapping("/myLife/{boardLifeCycle}")
//    public List<BoardVO> mylifeCycle(@PathVariable("boardLifeCycle") String boardLifeCycle ,  HttpSession session ,BoardVO boardVO){
//        Long uniId = (Long) session.getAttribute("uniId");
//        return boardService.selectLifeCycle(boardLifeCycle,uniId);
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
