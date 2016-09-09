package com.qzw.modules.dto;


import java.util.List;
import java.util.Map;

//所有AJAX请求返回类型，封装json结果
public class ApartmentResult<T> {

    private  boolean success;

    private T date;

    private String error;

    private List list;

    private Long count;

    public ApartmentResult(boolean success, List list,Long count) {
        this.count = count;
        this.list = list;
        this.success = success;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public ApartmentResult(boolean success, String error) {
        this.error = error;
        this.success = success;
    }
    public ApartmentResult(boolean success, List list) {
        this.list = list;
        this.success = success;
    }

    public ApartmentResult(boolean success, T date) {
        this.date = date;
        this.success = success;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
