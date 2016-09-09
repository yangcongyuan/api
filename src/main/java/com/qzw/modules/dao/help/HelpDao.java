package com.qzw.modules.dao.help;

import java.util.List;
import java.util.Map;

import com.qzw.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface HelpDao 
{
	public List<Map<String, Object>> queryQuestionTypeSel();
	
	public List<Map<String, Object>> queryQuestion(Map<String, Object> args);
	
	public List<Map<String, Object>> queryQuestion10();
}








