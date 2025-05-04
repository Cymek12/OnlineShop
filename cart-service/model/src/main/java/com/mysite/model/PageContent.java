package com.mysite.model;

import java.util.List;

public class PageContent<T> {
    private Long totalElements;
    private int currentPage;
    private int totalPageNumber;
    private List<T> content;

    public PageContent(Long totalElements, int currentPage, int totalPageNumber, List<T> content) {
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.totalPageNumber = totalPageNumber;
        this.content = content;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    public List<T> getContent() {
        return content;
    }
}
