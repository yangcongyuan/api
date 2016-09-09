package com.qzw.modules.dao.apartment;

import com.qzw.common.persistence.CrudDao;
import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.apartment.Layout;

@MyBatisDao
public interface LayoutDao extends CrudDao<Layout>{
    int deleteByPrimaryKey(Integer layoutId);

    int insert(Layout record);

    int insertSelective(Layout record);

    Layout selectByPrimaryKey(Integer layoutId);

    int updateByPrimaryKeySelective(Layout record);

    int updateByPrimaryKey(Layout record);
}