package com.qzw.modules.dao.apartment;

import com.qzw.common.persistence.CrudDao;
import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.apartment.Environment;


@MyBatisDao
public interface EnvironmentDao extends CrudDao<Environment> {

    int deleteByPrimaryKey(Integer enviId);

    int insert(Environment record);

    int insertSelective(Environment record);

    Environment selectByPrimaryKey(Integer enviId);

    int updateByPrimaryKeySelective(Environment record);

    int updateByPrimaryKey(Environment record);
}