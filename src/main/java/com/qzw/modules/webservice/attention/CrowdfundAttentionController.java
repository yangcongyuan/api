package com.qzw.modules.webservice.attention;

import com.alibaba.fastjson.JSON;
import com.qzw.modules.dto.ApartmentResult;
import com.qzw.modules.service.attention.CrowdfundAttentionService;
import com.qzw.modules.webservice.attention.vo.CrowdfundAttentionRequestVo;
import com.qzw.modules.webservice.attention.vo.CrowdfundAttentionResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */

@Component
@Path(value = "attention")
public class CrowdfundAttentionController {

    @Autowired
    private CrowdfundAttentionService crowdfundAttentionService;

    /**
     * 添加关注
     * @param crowdfundAttentionRequestVo
     */
    @POST
    @Path("/insertAttention")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertAttention(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
        crowdfundAttentionService.insert(crowdfundAttentionRequestVo);
    }

    /**
     * 关注的列表
     * @param crowdfundAttentionRequestVo
     * @return
     */
    @POST
    @Path("/getList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getList(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
        ApartmentResult<CrowdfundAttentionResponseVo> result;
        try {
            List<CrowdfundAttentionResponseVo> list=crowdfundAttentionService.getList(crowdfundAttentionRequestVo);
         /*   for (CrowdfundAttentionResponseVo vo:list){
                vo.setNumber(crowdfundAttentionService.countNember(vo.getAttentionNo()));
            }*/
            Long count=crowdfundAttentionService.countList(crowdfundAttentionRequestVo);
            result=new ApartmentResult<CrowdfundAttentionResponseVo>(true,list,count);
        }catch (Exception e){
            result=new ApartmentResult<CrowdfundAttentionResponseVo>(true,e.getMessage());
        }
        return JSON.toJSONString(result);
    }

    /**
     * 取消关注
     * @param crowdfundAttentionRequestVo
     */
    @POST
    @Path("/updateById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(CrowdfundAttentionRequestVo crowdfundAttentionRequestVo){
        crowdfundAttentionService.updateById(crowdfundAttentionRequestVo);
    }

}
