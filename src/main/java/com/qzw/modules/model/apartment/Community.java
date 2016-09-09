package com.qzw.modules.model.apartment;

import java.util.Date;

public class Community {
    private Integer commId;

    private String commName;

    private String commAddress;

    private String commDesc;

    private Date createTime;

    private Boolean flagDelete;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    public String getCommAddress() {
        return commAddress;
    }

    public void setCommAddress(String commAddress) {
        this.commAddress = commAddress == null ? null : commAddress.trim();
    }

    public String getCommDesc() {
        return commDesc;
    }

    public void setCommDesc(String commDesc) {
        this.commDesc = commDesc == null ? null : commDesc.trim();
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
}