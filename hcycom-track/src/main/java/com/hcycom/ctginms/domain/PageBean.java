package com.hcycom.ctginms.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: Page
 * @Description: TODO
 * @Author: 白敏
 * @Date: 2019/6/12 10:44
 **/
public class PageBean<T> {

    @ApiModelProperty(value="返回集合")
    private List<T> lists;

    @ApiModelProperty(value="当前页数")
    private int currPage;

    public int getCurrPage() {
        return currPage;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @ApiModelProperty(value="每页显示的记录数")
    private int pageSize;

    @ApiModelProperty(value="总记录数")
    private int totalCount;

    @ApiModelProperty(value="总页数")
    private int totalPage;
}
