package com.example.geungeunhanjan.domain.dto.inquiryPage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class InquiryPage {
    // 페이지 네비게이션 관리(페이지 번호, 페이지 네비게이션 버튼(이전, 다음))

    // 페이지 세트 당 표시될 수
    private int pageCount;

    // 페이지 세트 시작숫자
    private int startPage;

    // 페이지 세트 <1 2 3 4 5>
    private int endPage;

    // 실제 가장 마지막 페이지
    private int realEnd;

    // 이전 버튼 표시 여부
    private boolean prev;

    // 다음 버튼 표시 여부
    private boolean next;

    // 전체 게시글 수
    private int total;

    // 화면에서 전달받은 page, amount 저장하는 객체
    private InquiryCriteria inquiryCriteria;

    public InquiryPage(InquiryCriteria inquiryCriteria, int total) {
        this(inquiryCriteria, total, 5);
    }

    public InquiryPage(InquiryCriteria inquiryCriteria, int total, int pageCount) {
        this.inquiryCriteria = inquiryCriteria;
        this.total = total;
        this.pageCount = pageCount;

        // 현재 페이지 기준으로 세트의 마지막 번호, 시작 번호 구하기
        // ceil() 통해 올림
        this.endPage = (int)(Math.ceil(inquiryCriteria.getInquiryPage() / (double)pageCount)) * pageCount;
        this.startPage = Math.max(1, endPage - pageCount + 1);


        // 게시글 전체 수로 실제 마지막 페이지 구하기
//        this.realEnd = (int)(Math.ceil(double)total) / criteria.getAmount());
        this.realEnd = (int) Math.ceil(total / (double) inquiryCriteria.getInquiryAmount());


        // 세트의 마지막 번호보다 실제 마지막 페이지 작을 시
        if(realEnd < endPage){
            // 세트 마지막 번호를 실제 마지막 페이지로 교체
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }

}
