package com.qzw.modules.dao.apartment;

import com.qzw.common.persistence.CrudDao;
import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.apartment.Model;

@MyBatisDao
public interface ModelDao extends CrudDao<Model> {
    int deleteByPrimaryKey(Integer modelId);

    int insert(Model record);

    int insertSelective(Model record);

    Model selectByPrimaryKey(Integer modelId);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}