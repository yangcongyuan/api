package com.qzw.modules.service.help;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qzw.modules.dao.help.HelpDao;

@Service
@Transactional
public class HelpService 
{
	@Autowired
	private HelpDao helpDao;
	
	public List<Map<String, Object>> queryQuestionTypeSel()
	{
		return helpDao.queryQuestionTypeSel();
	}
	
	public List<Map<String, Object>> queryQuestion(Map<String, Object> args)
	{
		return helpDao.queryQuestion(args);
	}
	
	public List<Map<String, Object>> queryQuestion10()
	{
		return helpDao.queryQuestion10();
	}
}










