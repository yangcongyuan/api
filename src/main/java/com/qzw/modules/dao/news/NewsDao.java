package com.qzw.modules.dao.news;

import com.qzw.common.persistence.annotation.MyBatisDao;
import com.qzw.modules.model.news.News;
import com.qzw.modules.webservice.news.vo.NewsRequestVo;
import com.qzw.modules.webservice.news.vo.NewsResponseVo;

import java.util.List;


@MyBatisDao
public interface NewsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    /**
     * 获取新闻列表
     * @param newsRequestVo
     * @return
     */
    List<NewsResponseVo> newsList(NewsRequestVo newsRequestVo);

    /**
     * 获取新闻数量
     * @param newsRequestVo
     * @return
     */
    Long countNews(NewsRequestVo newsRequestVo);

    /**
     * 获取新闻的详细信息
     * @param newsRequestVo
     * @return
     */
    NewsResponseVo selectId(NewsRequestVo newsRequestVo);
}