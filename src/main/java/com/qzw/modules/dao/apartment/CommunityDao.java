package com.qzw.modules.dao.apartment;

import com.qzw.modules.model.apartment.Community;

public interface CommunityDao {
    int deleteByPrimaryKey(Integer commId);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(Integer commId);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);
}