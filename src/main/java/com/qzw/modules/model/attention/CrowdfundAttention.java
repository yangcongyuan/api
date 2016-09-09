package com.qzw.modules.model.attention;

import java.util.Date;

public class CrowdfundAttention {
    private Integer id;

    private Integer userId;

    private Integer attentionNo;

    private Integer attentionType;

    private Date attentionTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAttentionNo() {
        return attentionNo;
    }

    public void setAttentionNo(Integer attentionNo) {
        this.attentionNo = attentionNo;
    }

    public Integer getAttentionType() {
        return attentionType;
    }

    public void setAttentionType(Integer attentionType) {
        this.attentionType = attentionType;
    }

    public Date getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(Date attentionTime) {
        this.attentionTime = attentionTime;
    }
}