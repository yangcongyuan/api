package com.qzw.modules.dao.apartment;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.webservice.apartment.vo.ApartmentDetailVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentListVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentSearchVo;

import java.util.List;

@MyBatisDao
public interface ApartmentDao {

    List<ApartmentListVo> getApartmentList(ApartmentSearchVo apartmentSearchVo);

    ApartmentDetailVo getDetailById(Long aparId);

    Long countApartmentList(ApartmentSearchVo apartmentSearchVo);

    List<ApartmentListVo> getBuyApartmentList(ApartmentSearchVo apartmentSearchVo);

    Long countBuyApartmentList(ApartmentSearchVo apartmentSearchVo);
}