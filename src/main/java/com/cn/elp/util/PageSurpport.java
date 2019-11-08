package com.cn.elp.util;

import java.util.List;

public class PageSurpport<T> {
    private int pageIndex;//当前页
    private int pageCount;//总页数
    private int pageSize=3;//页大小
    private int totalCount;//总记录数
    private List<T> dataList;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        if(totalCount%pageSize==0){
            pageCount=totalCount/pageSize;
        }else {
            pageCount=totalCount/pageSize+1;
        }
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
