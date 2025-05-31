package com.mysite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageContent<T> {
    private Long totalElements;
    private int currentPage;
    private int totalPageNumber;
    private List<T> content;
}
