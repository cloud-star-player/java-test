package com.example.common.unit;

import java.io.Serializable;
import java.util.List;

/**
 * <p>ClassName: PageResult</p>
 * <p>Description:</p>
 *
 * @author 孙伟光
 * @version 1.0
 * @date 2020/3/31 16:38
 */
public class PageResult<T> implements Serializable {
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回编码
     */
    private Integer code;
    /**
     * 返回条数
     */
    private long count;
    private Integer pages;      //总页数
    private Integer pageNum;	//当前页数(从1开始)
    private Boolean sfFirstPage; //是否为第一页
    private Boolean sfLastPage; //是否为最后一页
    private Boolean hasPreviousPage; //是否有上一页
    private Boolean hasNextPage; //是否有下一页
    private int firstPage;  //首页页码
    private int lastPage;   //尾页页码
    private int[] navigatepageNums; //所有导航页号
    private Integer pageSize;   //当前页面显示的数据条目





    /**
     * 返回数据
     */
    private List<T> data;

    public PageResult() {
        this.code = 200;
        this.msg = "OK";
        this.count = 0;
        this.data = null;
    }

    public PageResult(List<T> data, long count) {
        this.code = 200;
        this.msg = "OK";
        this.count = count;
        this.data = data;
    }

    public PageResult(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
        this.count = 0;
        this.data = null;
    }

    /**
     * 传递消息和编码
     * @param msg 消息
     * @param code 编码
     * @param <T> 类型
     * @return PageResult对象
     */
    public static <T> PageResult<T> build(String msg, Integer code){
        return new PageResult<>(msg, code);
    }

    /**
     * 传递数据和条数
     * @param data 数据集合
     * @param count 条数
     * @param <T> 类型
     * @return PageResult对象
     */
    public static <T> PageResult<T> ok(List<T> data, long count){
        return new PageResult<>(data, count);
    }

    //getter and setter方法

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }


    public Boolean getSfFirstPage() {
        return sfFirstPage;
    }

    public void setSfFirstPage(Boolean sfFirstPage) {
        this.sfFirstPage = sfFirstPage;
    }

    public Boolean getSfLastPage() {
        return sfLastPage;
    }

    public void setSfLastPage(Boolean sfLastPage) {
        this.sfLastPage = sfLastPage;
    }

    public Boolean getHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(Boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
