package com.example.geungeunhanjan.domain.dto.lifePage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class   Slice<T> {
    boolean hasNext;
    List<T> contentList;
}
