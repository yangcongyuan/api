package com.qzw.modules.webservice.home;

import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.qzw.modules.service.home.HomeService;

@Path("/home")
public class HomeController 
{
	@Autowired
	private HomeService homeService;
	
	@Path("/queryBanner")
    @POST
    public String queryBanner()
    {
		List<Map<String, Object>> list = homeService.queryBanner();
        return JSON.toJSONString(list);
    }
	
	@Path("/queryHousePrice")
    @POST
    @SuppressWarnings("unchecked")
    public String queryHousePrice(String json)
    {
		Map<String, Object> args = JSON.parseObject(json, Map.class);
		List<Map<String, Object>> list = homeService.queryHousePrice(args);
        return JSON.toJSONString(list);
    }
	
	@Path("/queryIntroduce")
    @POST
    public String queryIntroduce()
    {
		List<Map<String, Object>> list = homeService.queryIntroduce();
        return JSON.toJSONString(list);
    }
	
	@Path("/queryLayoutRecommend")
    @POST
    public String queryLayoutRecommend()
    {
		List<Map<String, Object>> list = homeService.queryLayoutRecommend();
        return JSON.toJSONString(list);
    }
	
	@Path("/queryLayoutOverview")
    @POST
    public String queryLayoutOverview()
    {
		List<Map<String, Object>> list = homeService.queryLayoutOverview();
        return JSON.toJSONString(list);
    }
	
	@Path("/queryInformation")
    @POST
    public String queryInformation()
    {
		List<Map<String, Object>> list = homeService.queryInformation();
        return JSON.toJSONString(list);
    }
}












