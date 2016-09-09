package com.qzw.modules.service.home;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qzw.common.utils.DateUtils;
import com.qzw.modules.dao.home.HomeDao;

@Service
@Transactional
public class HomeService 
{
	@Autowired
	private HomeDao homeDao;
	
	public List<Map<String, Object>> queryBanner()
	{
		return homeDao.queryBanner();
	}
	
	public List<Map<String, Object>> queryHousePrice(Map<String, Object> args)
	{
		Date dateFromD = DateUtils.getDateCompute(new Date(), -180);
		String dateFrom = DateUtils.parseDate(dateFromD);
		args.put("dateFrom", dateFrom);
		return homeDao.queryHousePrice(args);
	}
	
	public List<Map<String, Object>> queryIntroduce()
	{
		return homeDao.queryIntroduce();
	}
	
	public List<Map<String, Object>> queryLayoutRecommend()
	{
		return homeDao.queryLayoutRecommend();
	}
	
	public List<Map<String, Object>> queryLayoutOverview()
	{
		return homeDao.queryLayoutOverview();
	}
	
	public List<Map<String, Object>> queryInformation()
	{
		return homeDao.queryInformation();
	}
}












