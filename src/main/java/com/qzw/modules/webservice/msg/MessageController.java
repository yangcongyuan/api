package com.qzw.modules.webservice.msg;

import com.alibaba.fastjson.JSON;
import com.qzw.modules.dto.ApartmentResult;
import com.qzw.modules.service.msg.MessageService;
import com.qzw.modules.webservice.msg.vo.MessageRequestVo;
import com.qzw.modules.webservice.msg.vo.MessageResponseVo;
import com.qzw.modules.webservice.news.vo.NewsRequestVo;
import com.qzw.modules.webservice.news.vo.NewsResponseVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
@Consumes
@Path(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 添加站内信
     * @param messageRequestVo
     */
    @Path("/insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(MessageRequestVo messageRequestVo){

             messageService.insert(messageRequestVo);


    }

    /**
     * 修改站内信状态
     * @param messageRequestVo
     */
    @Path("/updateById")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateById(MessageRequestVo messageRequestVo){
        messageService.updateById(messageRequestVo);
    }

    /**
     *站内信列表
     * @param messageRequestVo
     * @return
     */
    @POST
    @Path("/statueList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String statueList(MessageRequestVo messageRequestVo){
        ApartmentResult<MessageResponseVo> result;
        try {
            List<MessageResponseVo> list=messageService.statueList(messageRequestVo);
            Long count=messageService.countStatue(messageRequestVo);
            result=new ApartmentResult<MessageResponseVo>(true,list,count);
        }catch (Exception e){
            result=new ApartmentResult<MessageResponseVo>(true,e.getMessage());
        }
        return JSON.toJSONString(result);
    }

    /**
     * 删除站内信
     * @param messageRequestVo
     */
    @Path("/deleteById")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteById(MessageRequestVo messageRequestVo){
        messageService.deleteById(messageRequestVo);
    }

}
