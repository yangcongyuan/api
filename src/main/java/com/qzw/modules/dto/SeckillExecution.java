package com.qzw.modules.dto;

import com.qzw.modules.enums.SeckillStateEnum;
import com.qzw.modules.model.apartment.seckill.SeckillSuccess;

/**
 * 执行秒杀后的结果
 * Created by LJ on 2016/6/21.
 */
public class SeckillExecution {
    private long seckillId;

    //秒杀执行结果状态
    private int state;

    private String stateInfo;

    private SeckillSuccess seckillSuccess;

    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum, SeckillSuccess seckillSuccess) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.seckillSuccess = seckillSuccess;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum stateEnum) {
        this.seckillId = seckillId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SeckillSuccess getSeckillSuccess() {
        return seckillSuccess;
    }

    public void setSeckillSuccess(SeckillSuccess seckillSuccess) {
        this.seckillSuccess = seckillSuccess;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", seckillSuccess=" + seckillSuccess +
                '}';
    }
}
