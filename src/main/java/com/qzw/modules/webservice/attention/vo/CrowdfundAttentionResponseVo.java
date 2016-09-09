package com.qzw.modules.webservice.attention.vo;

import java.util.Date;

public class CrowdfundAttentionResponseVo {
    private Integer id;

    private Integer userId;                 //关注的用户

    private Integer attentionNo;            //关注的编号

    private Integer attentionType;           //关注的类型

    private Date attentionTime;             //关注的时间

    private  Long number;                //关注的人数

    private Integer aparId;             //房源编号

    private Integer buildingNo;         //楼号

    private Integer unitNo;             //单元号

    private Integer floorNo;            //楼层号

    private Integer aparNo;             //房间号

    private String listImg;             //列表图片

    private Integer aparHouseTypeId;    //户型主键

    private Integer unitPrice;          //单价

    private Integer sellPrice;          //售价

    private String turned;              //A东B南C西D北E南北F东西G东南H西南I东北J西北

    private String area;                //建筑面积

    private String room;                //几室

    private String hall;                //几厅

    private boolean flagAttention;   //是否关注

    private String decorate;        //装修情况：A毛坯B简单装修C中等装修D精装修E豪华装修

    private String lrDesc;            //描述

    public String getLrDesc() {
        return lrDesc;
    }

    public void setLrDesc(String lrDesc) {
        this.lrDesc = lrDesc;
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }

    public boolean isFlagAttention() {
        return flagAttention;
    }

    public void setFlagAttention(boolean flagAttention) {
        this.flagAttention = flagAttention;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getTurned() {
        return turned;
    }

    public void setTurned(String turned) {
        this.turned = turned;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
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

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public Integer getAparHouseTypeId() {
        return aparHouseTypeId;
    }

    public void setAparHouseTypeId(Integer aparHouseTypeId) {
        this.aparHouseTypeId = aparHouseTypeId;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getAparId() {
        return aparId;
    }

    public void setAparId(Integer aparId) {
        this.aparId = aparId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

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