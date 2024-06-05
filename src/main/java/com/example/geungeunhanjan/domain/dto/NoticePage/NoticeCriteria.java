package com.example.geungeunhanjan.domain.dto.NoticePage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter @ToString
public class NoticeCriteria {
    //페이징 파라미터 저장
    private int page;//현재 페이지가 담길 필드
    private int amount ;//한 페이지당 게시물 수

    //기본 생성자를 통해 기본 값 설정
    //사용자가 별도의 값을 지정하지 않았을때 사용할
    //기본 값(페이지번호 1, 한페이지당 게시물 수를 8로 설정 등)
    public NoticeCriteria(){
        this(1,8);
    }

    public NoticeCriteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }



}
