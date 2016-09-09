package com.qzw.modules.dao.home;

import java.util.List;
import java.util.Map;

import com.qzw.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface HomeDao 
{
	public List<Map<String, Object>> queryBanner();
	
	public List<Map<String, Object>> queryHousePrice(Map<String, Object> args);
	
	public List<Map<String, Object>> queryIntroduce();
	
	public List<Map<String, Object>> queryLayoutRecommend();
	
	public List<Map<String, Object>> queryLayoutOverview();
	
	public List<Map<String, Object>> queryInformation();
}













