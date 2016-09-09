package com.qzw.modules.model.user;

import java.math.BigDecimal;
import java.util.Date;

public class UserMoney {
    private Integer umId;

    private Integer userId;

    private BigDecimal money;

    private String moneyType;

    private BigDecimal chargePercent;

    private BigDecimal charge;

    private BigDecimal balance;

    private Integer adId;

    private Date createTime;

    public Integer getUmId() {
        return umId;
    }

    public void setUmId(Integer umId) {
        this.umId = umId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType == null ? null : moneyType.trim();
    }

    public BigDecimal getChargePercent() {
        return chargePercent;
    }

    public void setChargePercent(BigDecimal chargePercent) {
        this.chargePercent = chargePercent;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}