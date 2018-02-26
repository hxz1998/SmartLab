package org.mrhu.smartlab.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.mrhu.smartlab.dao.NewsDao;
import org.mrhu.smartlab.model.News;
import org.mrhu.smartlab.service.NewsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao;

    public NewsDao getNewsDao() {
        return newsDao;
    }

    @Resource
    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public void save(News news) {

    }

    @Override
    public News get(News exampleNews) {
        return newsDao.load(exampleNews);
    }

    @Override
    public void delete(News news) {

    }

    @Override
    public News update(News news) {
        return null;
    }

    @Override
    public String getJson(News news) {
        String json = JSON.toJSONString(news);
        return json;
    }

    @Override
    public String getAllJson() {
        List<News> allNews = newsDao.getAll();
        return JSON.toJSONStringWithDateFormat(allNews, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
    }


}
