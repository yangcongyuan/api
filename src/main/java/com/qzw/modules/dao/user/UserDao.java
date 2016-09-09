package com.qzw.modules.dao.user;

import java.util.Map;

import com.qzw.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface UserDao
{
	public int addValicode(Map<String, Object> args);
	
	public int delValicode(Map<String, Object> args);
	
	public int addUser(Map<String, Object> args);
	
	public int addPerson(Map<String, Object> args);
	
	public int addUserAddress(Map<String, Object> args);
	
	public String queryValicode(Map<String, Object> args);
	
	public int queryCellphoneExist(Map<String, Object> args);
	
	public int queryEmailExist(Map<String, Object> args);
	
	public int queryLoginnameExist(Map<String, Object> args);
	
	public Map<String, Object> queryUserInfo(Map<String, Object> args);
	
	public int updUser(Map<String, Object> args);
	
	public int updPerson(Map<String, Object> args);
	
	public int updUserAddress(Map<String, Object> args);
	
	public int valiPassword(Map<String, Object> args);
	
	public int updPassword(Map<String, Object> args);
	
	public int updCellphone(Map<String, Object> args);
	
	public int updEmail(Map<String, Object> args);
	
	public int queryPhoneEmailExist(Map<String, Object> args);
	
	public int resetPwd(Map<String, Object> args);
	
	public int updHeadImg(Map<String, Object> args);
	
}








