package com.qzw.modules.service.user;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.qzw.common.channel.email.SendMail;
import com.qzw.common.channel.phone.AliMsgApi;
import com.qzw.common.utils.RandomUtils;
import com.qzw.modules.dao.user.UserDao;

@Service
@Transactional
public class UserService 
{
    @Autowired
    private UserDao userDao;
    
    /**
     * 注册的时候发送短信验证码，并且验证手机号是否存在
     * 绑定手机号的时候，发送短信验证码，并且验证手机号是否存在
     * @param args
     * @return
     */
    public String sendSmsValicodeRegist(Map<String, Object> args)
    {
    	if( userDao.queryCellphoneExist(args) > 0 )
    	{
    		return "2";
    	}
    	args.put("phone_mail", args.get("cellphone"));
    	sendValicode(args);
        return "0";
    }
    
    /**
     * 绑定邮箱的时候，发送验证码，并且验证邮箱是否存在
     * @param args
     * @return
     */
    public String sendEmailValicodeBind(Map<String, Object> args)
    {
    	if( userDao.queryEmailExist(args) > 0 )
    	{
    		return "2";
    	}
    	args.put("phone_mail", args.get("email"));
    	sendValicode(args);
        return "0";
    }
    
    /**
     * 忘记密码，发送验证码，并且验证手机或邮箱是否存在
     * @param args
     * @return
     */
    public String sendValicodeFindPwd(Map<String, Object> args)
    {
    	if( userDao.queryPhoneEmailExist(args) == 0 )
    	{
    		return "2";
    	}
    	sendValicode(args);
        return "0";
    }
    
    /**
     * 发送短信或手机验证码
     * @param args
     */
    public void sendValicode(Map<String, Object> args)
    {
    	String phone_mail = (String) args.get("phone_mail");
        String valicode = RandomUtils.getValiCode();
        args.put("valicode", valicode);
        args.put("create_time", new Date());
        userDao.delValicode(args);
        userDao.addValicode(args);
        if( phone_mail.contains("@") )
        {
        	String subject = "棋子湾验证码";
        	String content = "验证码" + valicode + "，您正在进行棋子湾身份验证，打死不要告诉别人哦！";
        	SendMail.send(phone_mail, subject, content);
        }
        else 
        {
        	AliMsgApi.sendMsg(null, phone_mail, valicode);
		}
    }
    
    public String regist(Map<String, Object> args)
    {
    	args.put("phone_mail", args.get("cellphone"));
    	String valicode = userDao.queryValicode(args);
    	String smsValicode = (String) args.get("smsValicode");
    	if( valicode == null || valicode.length() == 0 ||
    		smsValicode == null || smsValicode.length() == 0 ||
    		! valicode.equals(smsValicode) )
    	{
    		return "1";
    	}
    	if( userDao.queryCellphoneExist(args) > 0 )
    	{
    		return "2";
    	}
    	String password = (String) args.get("password");
    	password = DigestUtils.md5DigestAsHex(password.getBytes());
    	args.put("password", password);
    	args.put("create_time", new Date());
    	userDao.addUser(args);
    	userDao.addPerson(args);
    	userDao.addUserAddress(args);
    	return "0";
    }
    
    public Map<String, Object> queryUserInfo(Map<String, Object> args)
    {
    	String password = (String) args.get("password");
    	if( password != null && password.length() > 0 )
    	{
    		password = DigestUtils.md5DigestAsHex(password.getBytes());
        	args.put("password", password);
    	}
    	return userDao.queryUserInfo(args);
    }
    
    public String updUserInfo(Map<String, Object> args)
    {
    	String login_name = (String) args.get("login_name");
    	if( login_name != null && login_name.length() > 0 &&
    		userDao.queryLoginnameExist(args) > 0 )
    	{
    		return "2";
    	}
    	String birthday = (String) args.get("birthday");
    	if( birthday != null && birthday.length() == 0 )
    	{
    		args.put("birthday", null);
    	}
    	userDao.updUser(args);
    	userDao.updPerson(args);
    	userDao.updUserAddress(args);
    	return "0";
    }
    
    public void updHeadImg(Map<String, Object> args)
    {
    	userDao.updHeadImg(args);
    }
    
    public String updPassword(Map<String, Object> args)
    {
    	String password = (String) args.get("password");
    	password = DigestUtils.md5DigestAsHex(password.getBytes());
    	args.put("password", password);
    	String passwordNew = (String) args.get("passwordNew");
    	passwordNew = DigestUtils.md5DigestAsHex(passwordNew.getBytes());
    	args.put("passwordNew", passwordNew);
    	if( userDao.valiPassword(args) == 0 )
    	{
    		return "1";
    	}
    	userDao.updPassword(args);
    	return "0";
    }
    
    public String valiValicode(Map<String, Object> args)
    {
    	String valicodeR = userDao.queryValicode(args);
    	String valicode = (String) args.get("valicode");
    	if( valicodeR == null || valicodeR.length() == 0 ||
    		valicode == null || valicode.length() == 0 ||
    		! valicodeR.equals(valicode) )
    	{
    		return "1";
    	}
    	else 
    	{
    		return "0";
		}
    }
    
    public String bindCellphone(Map<String, Object> args)
    {
    	args.put("phone_mail", args.get("cellphone"));
    	String valicodeR = userDao.queryValicode(args);
    	String valicode = (String) args.get("valicode");
    	if( valicodeR == null || valicodeR.length() == 0 ||
    		valicode == null || valicode.length() == 0 ||
    		! valicodeR.equals(valicode) )
    	{
    		return "1";
    	}
    	if( userDao.queryCellphoneExist(args) > 0 )
    	{
    		return "2";
    	}
    	userDao.updCellphone(args);
    	return "0";
    }
    
    public String bindEmail(Map<String, Object> args)
    {
    	args.put("phone_mail", args.get("email"));
    	String valicodeR = userDao.queryValicode(args);
    	String valicode = (String) args.get("valicode");
    	if( valicodeR == null || valicodeR.length() == 0 ||
    		valicode == null || valicode.length() == 0 ||
    		! valicodeR.equals(valicode) )
    	{
    		return "1";
    	}
    	if( userDao.queryEmailExist(args) > 0 )
    	{
    		return "2";
    	}
    	userDao.updEmail(args);
    	return "0";
    }
    
    public String valiFindPwd(Map<String, Object> args)
    {
    	String valicodeR = userDao.queryValicode(args);
    	String valicode = (String) args.get("valicode");
    	if( valicodeR == null || valicodeR.length() == 0 ||
    		valicode == null || valicode.length() == 0 ||
    		! valicodeR.equals(valicode) )
    	{
    		return "1";
    	}
    	if( userDao.queryPhoneEmailExist(args) == 0 )
    	{
    		return "2";
    	}
    	return "0";
    }
    
    public String resetPwd(Map<String, Object> args)
    {
    	String errcode = valiFindPwd(args);
    	if( errcode.equals("0") )
    	{
    		String password = (String) args.get("password");
        	password = DigestUtils.md5DigestAsHex(password.getBytes());
        	args.put("password", password);
        	userDao.resetPwd(args);
    	}
    	return errcode;
    }
    
}










