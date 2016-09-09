package com.qzw.modules.webservice.apartment.vo;

import java.util.List;

/**
 * Created by admin on 2016/8/1.
 */
public class ApartmentAttrVo {

    private List<OptionVo> type;                 //房屋类型
    private List<OptionVo> houseType;           //户型
    private List<OptionVo> area;                //面积

    public List<OptionVo> getType() {
        return type;
    }

    public void setType(List<OptionVo> type) {
        this.type = type;
    }

    public List<OptionVo> getHouseType() {
        return houseType;
    }

    public void setHouseType(List<OptionVo> houseType) {
        this.houseType = houseType;
    }

    public List<OptionVo> getArea() {
        return area;
    }

    public void setArea(List<OptionVo> area) {
        this.area = area;
    }
}
