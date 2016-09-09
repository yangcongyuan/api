package com.qzw.modules.model.apartment;

import java.util.Date;

public class Environment {
    private Integer enviId;

    private String enviName;

    private String enviPic1;

    private String enviPic2;

    private String enviPic3;

    private String enviPic4;

    private String enviPic5;

    private Date createTime;

    private Boolean flagDelete;

    private Integer commId;

    public Integer getEnviId() {
        return enviId;
    }

    public void setEnviId(Integer enviId) {
        this.enviId = enviId;
    }

    public String getEnviName() {
        return enviName;
    }

    public void setEnviName(String enviName) {
        this.enviName = enviName == null ? null : enviName.trim();
    }

    public String getEnviPic1() {
        return enviPic1;
    }

    public void setEnviPic1(String enviPic1) {
        this.enviPic1 = enviPic1 == null ? null : enviPic1.trim();
    }

    public String getEnviPic2() {
        return enviPic2;
    }

    public void setEnviPic2(String enviPic2) {
        this.enviPic2 = enviPic2 == null ? null : enviPic2.trim();
    }

    public String getEnviPic3() {
        return enviPic3;
    }

    public void setEnviPic3(String enviPic3) {
        this.enviPic3 = enviPic3 == null ? null : enviPic3.trim();
    }

    public String getEnviPic4() {
        return enviPic4;
    }

    public void setEnviPic4(String enviPic4) {
        this.enviPic4 = enviPic4 == null ? null : enviPic4.trim();
    }

    public String getEnviPic5() {
        return enviPic5;
    }

    public void setEnviPic5(String enviPic5) {
        this.enviPic5 = enviPic5 == null ? null : enviPic5.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }
}