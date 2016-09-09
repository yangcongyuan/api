package com.qzw.modules.dao.apartment.attr;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.webservice.apartment.vo.OptionVo;

import java.util.List;

@MyBatisDao
public interface ApartmentAreaDao {

    List<OptionVo> getListByCommId(Integer commId);
}