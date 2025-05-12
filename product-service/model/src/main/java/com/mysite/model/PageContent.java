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

    public PageContent() {
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    public void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
