package com.qzw.modules.webservice.news;


import com.alibaba.fastjson.JSON;
import com.qzw.modules.dto.ApartmentResult;
import com.qzw.modules.service.help.HelpService;
import com.qzw.modules.service.news.NewsService;
import com.qzw.modules.webservice.news.vo.NewsRequestVo;
import com.qzw.modules.webservice.news.vo.NewsResponseVo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/news")
public class NewsController
{
    @Autowired
    private NewsService newsService;


    /**
     * 获取新闻列表
     * @param newsRequestVo
     * @return
     */
    @POST
    @Path("/newsList")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newsList(NewsRequestVo newsRequestVo){
        ApartmentResult<NewsResponseVo> result;
        try {
            List<NewsResponseVo> list=newsService.newsList(newsRequestVo);
            Long count=newsService.countNews(newsRequestVo);
            result=new ApartmentResult<NewsResponseVo>(true,list,count);
        }catch (Exception e){
            result=new ApartmentResult<NewsResponseVo>(true,e.getMessage());
        }
        return JSON.toJSONString(result);
    }
    /**
     * 获取新闻详细信息
     * @param newsRequestVo
     * @return
     */
    @POST
    @Path("/selectId")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String selectId(NewsRequestVo newsRequestVo){

        ApartmentResult<NewsResponseVo> result;
        try {
            NewsResponseVo list=newsService.selectId(newsRequestVo);
            result=new ApartmentResult<NewsResponseVo>(true,list);
        }catch (Exception e){
            result=new ApartmentResult<NewsResponseVo>(true,e.getMessage());
        }
        return JSON.toJSONString(result);
    }
}












