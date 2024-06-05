package com.example.geungeunhanjan.domain.dto.NoticePage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class NoticePage {
    //페이지 네비게이션을 관리 (페이지 번호 , 페이지 네비게이션 버튼(이전,다음))


    //페이지 세트 당 표시될 수
    private int pageCount;
    //페이지 세트의 시작 숫자
    private int startPage;
    //페이지 세트의 마지막 숫자
    private int endPage;
    //실제 가장 마지막 페이지
    private int realEnd;
    //이전 버튼 표시 여부
    private boolean prev;
    //다음 버튼 표시 여부
    private boolean next;
    //전체 게시글 수
    private int total;
    //화면에서 전달받은 페이지 page , amount를 저장하는 객체
    private NoticeCriteria noticeCriteria;

    public NoticePage(NoticeCriteria noticeCriteria , int total) {
        this(noticeCriteria, total, 5);
    }


    public NoticePage(NoticeCriteria noticeCriteria, int total, int pageCount) {
        this.noticeCriteria = noticeCriteria;
        this.total = total;
        this.pageCount = pageCount;

        //현재 페이지를 기준으로 세트의 마지막 번호, 시작번호를 구한다
        //ceil() : 올림처리 메소드
        this.endPage = (int)(Math.ceil(noticeCriteria.getPage()/(double)pageCount)) * pageCount;
        this.startPage = endPage - pageCount +1;

        //게시글 전체 수로 실제 마지막 페이지를 구한다
        this.realEnd = (int)Math.ceil((double)total/noticeCriteria.getAmount());

        //세트의 마지막 번호보다 실제 마지막 페이지가 작다면 ?
        if(realEnd < endPage){
            //세트의 마지막 번호를 실제 마지막 페이지로 교체한다
            this.endPage = realEnd == 0? 1 : realEnd;
        }

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
