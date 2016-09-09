package com.qzw.modules.dao.apartment.seckill;

import com.qzw.common.persistence.CrudDao;
import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.apartment.seckill.ApartmentSeckill;

import java.util.Map;


@MyBatisDao
public interface ApartmentSeckillDao extends CrudDao<ApartmentSeckill>{

    void killByProcedure(Map<String, Object> map);
}