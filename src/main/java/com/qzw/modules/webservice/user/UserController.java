package com.qzw.modules.webservice.user;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.qzw.modules.service.user.UserService;

@Path("/user")
public class UserController {

    @Autowired
    private UserService userService;

	@Path("/sendSmsValicodeRegist")
    @POST
    @SuppressWarnings("unchecked")
    public String sendSmsValicodeRegist(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.sendSmsValicodeRegist(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/sendEmailValicodeBind")
    @POST
    @SuppressWarnings("unchecked")
    public String sendEmailValicodeBind(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.sendEmailValicodeBind(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/regist")
    @POST
    @SuppressWarnings("unchecked")
    public String regist(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.regist(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/queryUserInfo")
    @POST
    @SuppressWarnings("unchecked")
    public String queryUserInfo(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        Map<String, Object> result = userService.queryUserInfo(args);
        return JSON.toJSONString(result);
    }
	
	@Path("/updUserInfo")
    @POST
    @SuppressWarnings("unchecked")
    public String updUserInfo(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.updUserInfo(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/updHeadImg")
    @POST
    @SuppressWarnings("unchecked")
    public String updHeadImg(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        userService.updHeadImg(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", "0");
        return JSON.toJSONString(result);
    }
	
	@Path("/updPassword")
    @POST
    @SuppressWarnings("unchecked")
    public String updPassword(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.updPassword(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/sendValicode")
    @POST
    @SuppressWarnings("unchecked")
    public String sendValicode(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        userService.sendValicode(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", "0");
        return JSON.toJSONString(result);
    }
	
	@Path("/valiValicode")
    @POST
    @SuppressWarnings("unchecked")
    public String valiValicode(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.valiValicode(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/bindCellphone")
    @POST
    @SuppressWarnings("unchecked")
    public String bindCellphone(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.bindCellphone(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/bindEmail")
    @POST
    @SuppressWarnings("unchecked")
    public String bindEmail(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.bindEmail(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/sendValicodeFindPwd")
    @POST
    @SuppressWarnings("unchecked")
    public String sendValicodeFindPwd(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.sendValicodeFindPwd(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/valiFindPwd")
    @POST
    @SuppressWarnings("unchecked")
    public String valiFindPwd(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.valiFindPwd(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
	@Path("/resetPwd")
    @POST
    @SuppressWarnings("unchecked")
    public String resetPwd(String json)
    {
        Map<String, Object> args = JSON.parseObject(json, Map.class);
        String errcode = userService.resetPwd(args);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errcode", errcode);
        return JSON.toJSONString(result);
    }
	
}










