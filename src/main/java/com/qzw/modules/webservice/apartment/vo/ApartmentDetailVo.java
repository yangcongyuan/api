package com.qzw.modules.webservice.apartment.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/8/1.
 */
public class ApartmentDetailVo {

    private Integer aparId;           //房源编号
    private String aparName;          //房源名称
    private Integer userId;           //用户编号
    private Integer commId;           //楼盘编号
    private Integer modelId;          //样板图编号
    private Integer layoutId;         //户型图编号
    private Integer enviId;           //环境图编号
    private int sellPrice;          //售价
    private int room;                   //室
    private int hall;                   //厅
    private String  aparType;         //房屋类型型
    private String area;              //房屋面积
    private Integer buildingNo;       //楼号
    private Integer unitNo;            //单元号
    private Integer floorNo;           //楼层号
    private Integer aparNo;             //房间号
    private Integer floorNum;           //一共几层
    private String turned;              //朝向   朝向 A东B南C西D北E南北F东西G东南H西南I东北J西北
    private Date createTime;           //创建日期
    private Date startTime;             //抢购开始时间
    private Date endTime;               //抢购结束时间
    private Integer year;               //年代
    private Integer unitPrice;           //单价
    private Boolean attention;              //是否关注
    private List<String> layout;        //户型图表
    private List<String> model;         //样板效果图室内图
    private List<String> environment;  //环境图图

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public Integer getEnviId() {
        return enviId;
    }

    public void setEnviId(Integer enviId) {
        this.enviId = enviId;
    }

    public Boolean getAttention() {
        return attention;
    }

    public void setAttention(Boolean attention) {
        this.attention = attention;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
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

    public List<String> getLayout() {
        return layout;
    }

    public void setLayout(List<String> layout) {
        this.layout = layout;
    }

    public List<String> getModel() {
        return model;
    }

    public void setModel(List<String> model) {
        this.model = model;
    }

    public List<String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(List<String> environment) {
        this.environment = environment;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
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
        this.turned = turned;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getAparType() {
        return aparType;
    }

    public void setAparType(String aparType) {
        this.aparType = aparType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
