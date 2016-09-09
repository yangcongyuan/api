package com.qzw.modules.dao.user;

import com.qzw.modules.model.user.UserAddress;

public interface UserAddressMapper {
    int insert(UserAddress record);

    int insertSelective(UserAddress record);
}