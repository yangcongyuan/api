package com.qzw.modules.webservice.apartment.vo;

import java.util.Date;

/**
 * Created by admin on 2016/8/1.
 */
public class ApartmentListVo {

    private Integer aparId;                    //房源编号
    private String  listImg;                    //列表图片
    private Integer sellPrice;                  //售价
    private String aparName;                   //房源名称
    private String aparType;                   //房源类型
    private Integer area;                       //房源面积
    private Integer room;                       //几室
    private Integer hall;                       //几厅
    private Integer toilet;                     //几卫
    private long now;                           //系统当前时间
    private Date startTime;                //秒杀开启时间date
    private Date endTime;                   //秒杀结束时间date
    private Integer attentionCount;          //关注数
    private Integer buildingNo;              //楼号
    private Integer unitNo;                      //单元号
    private Integer floorNo;                    //楼层号
    private Integer aparNo;                     //房间号
    private Integer state;                       //状态   - 1 无效   0 成功  1 已付款
    private Date  createTime;                   //抢购时间
    private String decorate;                      //装修情况：A毛坯B简单装修C中等装修D精装修E豪华装修

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

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
        this.aparName = aparName;
    }

    public String getAparType() {
        return aparType;
    }

    public void setAparType(String aparType) {
        this.aparType = aparType;
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

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
