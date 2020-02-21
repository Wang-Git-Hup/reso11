package com.ujiuye.utils;
/*
*   模糊查询的工具类
* */
public class SerachInfo {

    private  Integer cid;
    private String keyword="";

    @Override
    public String toString() {
        return "SerachInfo{" +
                "cid=" + cid +
                ", keyword='" + keyword + '\'' +
                ", orderby=" + orderby +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    private Integer orderby;
}
