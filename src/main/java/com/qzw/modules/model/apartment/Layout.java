package com.qzw.modules.model.apartment;

import java.util.Date;

public class Layout {
    private Integer layoutId;

    private String layoutName;

    private String layoutPic1;

    private String layoutPic2;

    private String layoutPic3;

    private String layoutPic4;

    private String layoutPic5;

    private Date createTime;

    private Boolean flagDelete;

    public Integer getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName == null ? null : layoutName.trim();
    }

    public String getLayoutPic1() {
        return layoutPic1;
    }

    public void setLayoutPic1(String layoutPic1) {
        this.layoutPic1 = layoutPic1 == null ? null : layoutPic1.trim();
    }

    public String getLayoutPic2() {
        return layoutPic2;
    }

    public void setLayoutPic2(String layoutPic2) {
        this.layoutPic2 = layoutPic2 == null ? null : layoutPic2.trim();
    }

    public String getLayoutPic3() {
        return layoutPic3;
    }

    public void setLayoutPic3(String layoutPic3) {
        this.layoutPic3 = layoutPic3 == null ? null : layoutPic3.trim();
    }

    public String getLayoutPic4() {
        return layoutPic4;
    }

    public void setLayoutPic4(String layoutPic4) {
        this.layoutPic4 = layoutPic4 == null ? null : layoutPic4.trim();
    }

    public String getLayoutPic5() {
        return layoutPic5;
    }

    public void setLayoutPic5(String layoutPic5) {
        this.layoutPic5 = layoutPic5 == null ? null : layoutPic5.trim();
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