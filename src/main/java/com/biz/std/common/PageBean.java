package com.biz.std.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/5/14.
 */
public class PageBean<T> {

    /*
    * 当前页
    * */
    private int currentPage;

    /*
    * 总页数
    * */
    private int totalPage;

    /*
    * 分页的大小
    * */
    private int pageSize;

    private List<T> list = new ArrayList<>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
