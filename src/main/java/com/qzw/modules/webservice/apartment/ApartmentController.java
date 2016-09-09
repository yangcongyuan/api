package com.qzw.modules.webservice.apartment;

import com.alibaba.fastjson.JSON;
import com.qzw.modules.dto.ApartmentResult;
import com.qzw.modules.model.apartment.Apartment;
import com.qzw.modules.service.apartment.ApartmentService;
import com.qzw.modules.webservice.apartment.vo.ApartmentDetailVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentListVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentAttrVo;
import com.qzw.modules.webservice.apartment.vo.ApartmentSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Path("/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;


    /**
     * 获取房源检索条件
     * @return
     */
    @GET
    @Path("/search/options/{commId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String options(@PathParam("commId")Integer commId) {
        ApartmentResult<ApartmentAttrVo> result;
        try {
            ApartmentAttrVo vo = apartmentService.getSearchOptionsList(commId);
            result = new ApartmentResult<ApartmentAttrVo>(true, vo);

        } catch (Exception e) {
            result = new ApartmentResult<ApartmentAttrVo>(false, e.getMessage());
        }
        return JSON.toJSONString(result);
    }


    /**
     * 获取房源列表
     * @return
     */
    @POST
    @Path("/buy/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String buyList(ApartmentSearchVo apartmentSearchVo) {
        ApartmentResult<ApartmentListVo> result;
        try {
            List<ApartmentListVo> list = apartmentService.getBuyApartmentList(apartmentSearchVo);
            Long count = apartmentService.countBuyApartmentList(apartmentSearchVo);
            result = new ApartmentResult<ApartmentListVo>(true, list,count);

        } catch (Exception e) {
            result = new ApartmentResult<ApartmentListVo>(false, e.getMessage());
        }
        return JSON.toJSONString(result);
    }

    /**
     * 获取购买房源列表
     * @return
     */
    @POST
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String list(ApartmentSearchVo apartmentSearchVo) {
        ApartmentResult<ApartmentListVo> result;
        try {
            List<ApartmentListVo> list = apartmentService.getApartmentList(apartmentSearchVo);
            Long count = apartmentService.countApartmentList(apartmentSearchVo);
            result = new ApartmentResult<ApartmentListVo>(true, list,count);

        } catch (Exception e) {
            result = new ApartmentResult<ApartmentListVo>(false, e.getMessage());
        }
        return JSON.toJSONString(result);
    }

    /**
     * 获取房源详情
     * @param aparId
     * @return
     */
    @GET
    @Path("/{aparId}/detail")
    @Produces(MediaType.APPLICATION_JSON)
    public String detail(@PathParam("aparId")Long aparId,@QueryParam("userId")String userId) {
        ApartmentResult<ApartmentDetailVo> result;
        try {
            ApartmentDetailVo vo = apartmentService.getDetailById(aparId,userId);
            result = new ApartmentResult<ApartmentDetailVo>(true, vo);

        } catch (Exception e) {
            result = new ApartmentResult<ApartmentDetailVo>(false, e.getMessage());
        }
        return JSON.toJSONString(result);
    }
}
