package com.mysite.model;

public class MyPageable {
    private int size;
    private int page;

    public MyPageable(int size, int page) {
        this.size = size;
        this.page = page;
    }

    public MyPageable() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
