package com.qzw.modules.service.news;

import com.qzw.common.utils.DateUtils;
import com.qzw.modules.dao.news.NewsDao;
import com.qzw.modules.webservice.news.vo.NewsRequestVo;
import com.qzw.modules.webservice.news.vo.NewsResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/8/16.
 */
@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    /**
     * 获取新闻列表
     * @param newsRequestVo
     * @return
     */
    public List<NewsResponseVo> newsList(NewsRequestVo newsRequestVo){
        List<NewsResponseVo> list=newsDao.newsList(newsRequestVo);
        for (NewsResponseVo vo:list) {
            vo.setNowTimeString(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
            if (vo.getPublishDate()!=null){
                vo.setPublishTimeString(DateUtils.formatDate(vo.getPublishDate(),"yyyy-MM-dd HH:mm:ss"));

            }
            //vo.setNewsData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        return list;
    }
    /**
     * 获取新闻数量
     * @param newsRequestVo
     * @return
     */
    public Long countNews(NewsRequestVo newsRequestVo){
        return newsDao.countNews(newsRequestVo);
    }

    /**
     * 获取新闻详细信息
     * @param newsRequestVo
     * @return
     */
    public NewsResponseVo selectId(NewsRequestVo newsRequestVo){
        return newsDao.selectId(newsRequestVo);

    }
}
