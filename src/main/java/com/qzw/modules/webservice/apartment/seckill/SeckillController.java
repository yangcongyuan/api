package com.qzw.modules.webservice.apartment.seckill;


import com.alibaba.fastjson.JSON;
import com.qzw.modules.dto.Exposer;
import com.qzw.modules.dto.SeckillExecution;
import com.qzw.modules.dto.SeckillResult;
import com.qzw.modules.enums.SeckillStateEnum;
import com.qzw.modules.exception.RepeatkillException;
import com.qzw.modules.exception.SeckillCloseException;
import com.qzw.modules.service.apartment.seckill.SeckillService;
import org.glassfish.jersey.server.mvc.Viewable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.HashMap;


@Component
@Path("/apartment/seckill")
public class SeckillController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @GET
    @Path("/hello")
    public Viewable sayHello(@QueryParam("name") @DefaultValue("World") String name) {
        HashMap model = new HashMap();
        model.put("name", name);
        return new Viewable("/index", model);
    }


    /**
     * 获取系统时间
     * @return
     */
    @GET
    @Path("/time/now")
    @Produces(MediaType.APPLICATION_JSON)
    @Scope("prototype")
    public String time() {
        Date now = new Date();
        SeckillResult<Long>  result = new SeckillResult(true,now.getTime());
        return JSON.toJSONString(result);
    }


    /**
     * 获取秒杀地址
     * @param seckillId
     * @return
     */
    @POST
    @Path("/{seckillId}/exposer")
    @Produces(MediaType.APPLICATION_JSON)
    public String exposer(@PathParam("seckillId")Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return JSON.toJSONString(result);
    }

    /**
     * 开始秒杀
     * @param seckillId
     * @return
     */
    @POST
    @Path("/{seckillId}/{md5}/execution")
    @Produces(MediaType.APPLICATION_JSON)
    public String execute(@PathParam("seckillId")Long seckillId,@PathParam("md5")String md5,@QueryParam("userId") String userId) {
        SeckillResult<SeckillExecution> seckillResult;
        if(userId==null){
            seckillResult = new SeckillResult<SeckillExecution>(false,"未注册");
            return JSON.toJSONString(seckillResult);
        }
        SeckillResult<SeckillExecution> result ;
        try {
            //存储过程调用
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId,userId,md5);
            seckillResult =  new SeckillResult<SeckillExecution>(true,execution);
            return JSON.toJSONString(seckillResult);
        }catch (RepeatkillException e){
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.REPEAT_KILL);
            seckillResult = new SeckillResult<SeckillExecution>(true,execution);
            return JSON.toJSONString(seckillResult);
        }catch (SeckillCloseException e){
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.END);
            seckillResult = new SeckillResult<SeckillExecution>(true,execution);
            return JSON.toJSONString(seckillResult);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
            seckillResult = new SeckillResult<SeckillExecution>(true,execution);
            return JSON.toJSONString(seckillResult);
        }
    }

    public static void main(String[] args) {

    }


}
