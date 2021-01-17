package com.fh.shop_behind.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PageParams {
    private Integer currPage;
    private Integer size;

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
