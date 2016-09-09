package com.qzw.modules.webservice.help;

import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.qzw.modules.service.help.HelpService;

@Path("/help")
public class HelpController 
{
	@Autowired
	private HelpService helpService;
	
	@Path("/queryQuestionTypeSel")
    @POST
    public String queryQuestionTypeSel()
    {
		List<Map<String, Object>> list = helpService.queryQuestionTypeSel();
        return JSON.toJSONString(list);
    }
	
	@Path("/queryQuestion")
    @POST
    @SuppressWarnings("unchecked")
    public String queryQuestion(String json)
    {
		Map<String, Object> args = JSON.parseObject(json, Map.class);
		List<Map<String, Object>> list = helpService.queryQuestion(args);
        return JSON.toJSONString(list);
    }
	
	@Path("/queryQuestion10")
    @POST
    public String queryQuestion10()
    {
		List<Map<String, Object>> list = helpService.queryQuestion10();
        return JSON.toJSONString(list);
    }
}












