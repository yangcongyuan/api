package com.qzw.modules.webservice.apartment.vo;

/**
 * Created by admin on 2016/8/10.
 */
public class ApartmentSearchVo {

    private String searchText;              //搜索文本
    private Integer type;                   //房屋类型
    private Integer houseType;              //房屋户型
    private Integer area;                   //房屋面积

    private Integer userId;                  //用户编号

    private Integer currentPage;        //开始页
    private Integer pageSize;            //条数

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
