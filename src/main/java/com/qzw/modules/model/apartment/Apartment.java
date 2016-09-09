package com.qzw.modules.model.apartment;

import java.util.Date;

public class Apartment {
    private Integer aparId;

    private String aparName;

    private Integer commId;

    private Integer buildingNo;

    private Integer unitNo;

    private Integer floorNo;

    private Integer aparNo;

    private Integer area;

    private Integer room;

    private Integer hall;

    private Integer toilet;

    private Integer floorNum;

    private String turned;

    private String aparType;

    private String decorate;

    private Integer userId;

    private String aparStatus;

    private Integer sellPrice;

    private Integer dealPrice;

    private Integer transferPrice;

    private Date openDay;

    private Date netDay;

    private Date netDay7;

    private Date createTime;

    private Boolean flagDelete;

    private Integer layoutId;

    private Integer modelId;

    public Integer getAparId() {
        return aparId;
    }

    public void setAparId(Integer aparId) {
        this.aparId = aparId;
    }

    public String getAparName() {
        return aparName;
    }

    public void setAparName(String aparName) {
        this.aparName = aparName == null ? null : aparName.trim();
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getAparNo() {
        return aparNo;
    }

    public void setAparNo(Integer aparNo) {
        this.aparNo = aparNo;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public String getTurned() {
        return turned;
    }

    public void setTurned(String turned) {
        this.turned = turned == null ? null : turned.trim();
    }

    public String getAparType() {
        return aparType;
    }

    public void setAparType(String aparType) {
        this.aparType = aparType == null ? null : aparType.trim();
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate == null ? null : decorate.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAparStatus() {
        return aparStatus;
    }

    public void setAparStatus(String aparStatus) {
        this.aparStatus = aparStatus == null ? null : aparStatus.trim();
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(Integer dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Integer getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(Integer transferPrice) {
        this.transferPrice = transferPrice;
    }

    public Date getOpenDay() {
        return openDay;
    }

    public void setOpenDay(Date openDay) {
        this.openDay = openDay;
    }

    public Date getNetDay() {
        return netDay;
    }

    public void setNetDay(Date netDay) {
        this.netDay = netDay;
    }

    public Date getNetDay7() {
        return netDay7;
    }

    public void setNetDay7(Date netDay7) {
        this.netDay7 = netDay7;
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

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}