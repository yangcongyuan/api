package com.qzw.modules.service.apartment;

import com.google.common.collect.Lists;
import com.qzw.common.utils.StringUtils;
import com.qzw.modules.dao.apartment.ApartmentDao;
import com.qzw.modules.dao.apartment.EnvironmentDao;
import com.qzw.modules.dao.apartment.LayoutDao;
import com.qzw.modules.dao.apartment.ModelDao;
import com.qzw.modules.dao.apartment.attr.ApartmentAreaDao;
import com.qzw.modules.dao.apartment.attr.ApartmentHouseTypeDao;
import com.qzw.modules.dao.apartment.attr.ApartmentTypeDao;
import com.qzw.modules.dao.attention.CrowdfundAttentionDao;
import com.qzw.modules.model.apartment.Environment;
import com.qzw.modules.model.apartment.Layout;
import com.qzw.modules.model.apartment.Model;
import com.qzw.modules.webservice.apartment.vo.ApartmentDetailVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentListVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentAttrVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/7/28.
 */
@Service
public class ApartmentService {

    @Autowired
    private ApartmentDao apartmentDao;

    @Autowired
    private LayoutDao layoutDao;

    @Autowired
    private ModelDao modelDao;

    @Autowired
    private EnvironmentDao environmentDao;

    @Autowired
    private ApartmentAreaDao apartmentAreaDao;

    @Autowired
    private ApartmentHouseTypeDao apartmentHouseTypeDao;

    @Autowired
    private ApartmentTypeDao apartmentTypeDao;

    @Autowired
    private CrowdfundAttentionDao crowdfundAttentionDao;

    public List<ApartmentListVo> getApartmentList(ApartmentSearchVo apartmentSearchVo) {

        if(apartmentSearchVo.getSearchText() != null){
            apartmentSearchVo.setSearchText("%"+apartmentSearchVo.getSearchText()+"%");
        }
        List<ApartmentListVo> vo = apartmentDao.getApartmentList(apartmentSearchVo);
        //系统当前时间
        Date nowTime = new Date();
        for (ApartmentListVo item : vo){
            item.setNow(nowTime.getTime());
        }
        return vo;
    }

    public Long countApartmentList(ApartmentSearchVo apartmentSearchVo) {
        if(apartmentSearchVo.getSearchText() != null){
            apartmentSearchVo.setSearchText("%"+apartmentSearchVo.getSearchText()+"%");
        }
        return apartmentDao.countApartmentList(apartmentSearchVo);
    }

    public ApartmentDetailVo getDetailById(Long aparId,String userId) {
        ApartmentDetailVo vo = apartmentDao.getDetailById(aparId);
        Layout layout = layoutDao.get(vo.getLayoutId()+"");
        Model model =  modelDao.get(vo.getModelId()+"");
        Environment environment =  environmentDao.get(vo.getEnviId()+"");
        if(StringUtils.isNotEmpty(userId)){
            int count = crowdfundAttentionDao.checkAttionByUserId(aparId,userId);
            vo.setAttention(count == 0 ?false:true);
        }
        List<String> layoutStr = Lists.newArrayList();
        if(StringUtils.isNotEmpty(layout.getLayoutPic1())){
            layoutStr.add(layout.getLayoutPic1());
        }
        if(StringUtils.isNotEmpty(layout.getLayoutPic2())){
            layoutStr.add(layout.getLayoutPic2());
        }
        if(StringUtils.isNotEmpty(layout.getLayoutPic3())){
            layoutStr.add(layout.getLayoutPic3());
        }
        if(StringUtils.isNotEmpty(layout.getLayoutPic4())){
            layoutStr.add(layout.getLayoutPic4());
        }
        if(StringUtils.isNotEmpty(layout.getLayoutPic5())){
            layoutStr.add(layout.getLayoutPic5());
        }

        List<String> modelStr = Lists.newArrayList();
        if(StringUtils.isNotEmpty(model.getModelPic1())){
            modelStr.add(model.getModelPic1());
        }
        if(StringUtils.isNotEmpty(model.getModelPic2())){
            modelStr.add(model.getModelPic2());
        }
        if(StringUtils.isNotEmpty(model.getModelPic3())){
            modelStr.add(model.getModelPic3());
        }
        if(StringUtils.isNotEmpty(model.getModelPic4())){
            modelStr.add(model.getModelPic4());
        }
        if(StringUtils.isNotEmpty(model.getModelPic5())){
            modelStr.add(model.getModelPic5());
        }

        List<String> environmentStr = Lists.newArrayList();
        if(StringUtils.isNotEmpty(environment.getEnviPic1())){
            environmentStr.add(environment.getEnviPic1());
        }
        if(StringUtils.isNotEmpty(environment.getEnviPic2())){
            environmentStr.add(environment.getEnviPic2());
        }
        if(StringUtils.isNotEmpty(environment.getEnviPic3())){
            environmentStr.add(environment.getEnviPic3());
        }
        if(StringUtils.isNotEmpty(environment.getEnviPic4())){
            environmentStr.add(environment.getEnviPic4());
        }
        if(StringUtils.isNotEmpty(environment.getEnviPic5())){
            environmentStr.add(environment.getEnviPic5());
        }
//        String [] layoutStr = new String[3]  {
//                    layout.getLayoutPic1()!=null?layout.getLayoutPic1():,
//                    layout.getLayoutPic2(),
//                    layout.getLayoutPic3(),
//                    layout.getLayoutPic4(),
//                    layout.getLayoutPic5()
//                };
        //String [] modelStr = new String[]{model.getModelPic1(),model.getModelPic2(),model.getModelPic3(),model.getModelPic4(),model.getModelPic5()};
        //String [] environmentStr = new String[]{environment.getEnviPic1(),environment.getEnviPic2(),environment.getEnviPic3(),environment.getEnviPic4(),environment.getEnviPic5()};;

        vo.setLayout(layoutStr);
        vo.setModel(modelStr);
        vo.setEnvironment(environmentStr);

        return vo;
    }

    public ApartmentAttrVo getSearchOptionsList(Integer commId) {

        ApartmentAttrVo vo = new ApartmentAttrVo();

        vo.setArea(apartmentAreaDao.getListByCommId(commId));
        vo.setHouseType(apartmentHouseTypeDao.getListByCommId(commId));
        vo.setType(apartmentTypeDao.getListByCommId(commId));

        return vo;
    }


    public List<ApartmentListVo> getBuyApartmentList(ApartmentSearchVo apartmentSearchVo) {

        List<ApartmentListVo> vo = apartmentDao.getBuyApartmentList(apartmentSearchVo);
        return vo;
    }
    public Long countBuyApartmentList(ApartmentSearchVo apartmentSearchVo) {

        return apartmentDao.countBuyApartmentList(apartmentSearchVo);
    }
}
