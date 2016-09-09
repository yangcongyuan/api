package com.qzw.modules.dao.apartment.attr;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.webservice.apartment.vo.OptionVo;

import java.util.List;

@MyBatisDao
public interface ApartmentTypeDao {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(ApartmentType record);
//
//    int insertSelective(ApartmentType record);
//
//    ApartmentType selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(ApartmentType record);
//
//    int updateByPrimaryKey(ApartmentType record);

    List<OptionVo> getListByCommId(Integer commId);
}