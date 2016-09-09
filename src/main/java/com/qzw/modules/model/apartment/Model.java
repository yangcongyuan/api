package com.qzw.modules.model.apartment;

import java.util.Date;

public class Model {
    private Integer modelId;

    private String modelName;

    private String modelPic1;

    private String modelPic2;

    private String modelPic3;

    private String modelPic4;

    private String modelPic5;

    private Date createTime;

    private Boolean flagDelete;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getModelPic1() {
        return modelPic1;
    }

    public void setModelPic1(String modelPic1) {
        this.modelPic1 = modelPic1 == null ? null : modelPic1.trim();
    }

    public String getModelPic2() {
        return modelPic2;
    }

    public void setModelPic2(String modelPic2) {
        this.modelPic2 = modelPic2 == null ? null : modelPic2.trim();
    }

    public String getModelPic3() {
        return modelPic3;
    }

    public void setModelPic3(String modelPic3) {
        this.modelPic3 = modelPic3 == null ? null : modelPic3.trim();
    }

    public String getModelPic4() {
        return modelPic4;
    }

    public void setModelPic4(String modelPic4) {
        this.modelPic4 = modelPic4 == null ? null : modelPic4.trim();
    }

    public String getModelPic5() {
        return modelPic5;
    }

    public void setModelPic5(String modelPic5) {
        this.modelPic5 = modelPic5 == null ? null : modelPic5.trim();
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