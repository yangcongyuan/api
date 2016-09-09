package com.qzw.modules.dao.apartment.seckill;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.apartment.seckill.SeckillSuccess;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface SeckillSuccessDao {
    int deleteByPrimaryKey(Integer apartmentId);

    int insert(SeckillSuccess record);

    int insertSelective(SeckillSuccess record);

    SeckillSuccess selectByPrimaryKey(Integer apartmentId);

    int updateByPrimaryKeySelective(SeckillSuccess record);

    int updateByPrimaryKey(SeckillSuccess record);

    SeckillSuccess queryByIdWithSeckill(@Param("apartmentId") long apartment_id, @Param("userId") String userId);
}