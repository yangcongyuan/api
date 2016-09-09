package com.qzw.modules.dao.user;

import com.qzw.modules.model.user.UserMoney;

public interface UserMoneyMapper {
    int deleteByPrimaryKey(Integer umId);

    int insert(UserMoney record);

    int insertSelective(UserMoney record);

    UserMoney selectByPrimaryKey(Integer umId);

    int updateByPrimaryKeySelective(UserMoney record);

    int updateByPrimaryKey(UserMoney record);
}