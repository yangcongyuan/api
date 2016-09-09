package com.qzw.modules.dao.apartment.attr;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.webservice.apartment.vo.OptionVo;

import java.util.List;

@MyBatisDao
public interface ApartmentHouseTypeDao {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(ApartmentHouseType record);
//
//    int insertSelective(ApartmentHouseType record);
//
//    ApartmentHouseType selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(ApartmentHouseType record);
//
//    int updateByPrimaryKey(ApartmentHouseType record);

    List<OptionVo> getListByCommId(Integer commId);
}