package com.qzw.modules.webservice.news.vo;

import java.util.Date;

public class NewsResponseVo {
    private Integer id;

    private String title;                   //标题

    private Boolean publish;               //0 未发布  1 已发布

    private Date publishDate;               //发布日期

    private String detail;                  //内容

    private String info;                    //简介

    private String nowTimeString;           //当前时间

    private String publishTimeString;             //发布时间字符串

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getNowTimeString() {
        return nowTimeString;
    }

    public void setNowTimeString(String nowTimeString) {
        this.nowTimeString = nowTimeString;
    }

    public String getPublishTimeString() {
        return publishTimeString;
    }

    public void setPublishTimeString(String publishTimeString) {
        this.publishTimeString = publishTimeString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}