package com.example.geungeunhanjan.domain.dto.inquiryPage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class InuqirySlice<T> {
    boolean hasNext;
    List<T> contentList;
}
