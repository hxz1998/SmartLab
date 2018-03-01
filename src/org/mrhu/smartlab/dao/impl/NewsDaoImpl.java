package org.mrhu.smartlab.dao.impl;

import org.mrhu.smartlab.dao.NewsDao;
import org.mrhu.smartlab.model.News;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("newsDao")
public class NewsDaoImpl implements NewsDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(News news) {
        hibernateTemplate.save(news);
    }

    @Override
    public News load(News exampleNews) {
        News loadNews = hibernateTemplate.get(News.class, exampleNews.getId());
        return loadNews;
    }

    @Override
    public void delete(News news) {

    }

    @Override
    public News update(News news) {
        return null;
    }

    @Override
    public List<News> getAll() {
//        List<News> allNews = hibernateTemplate.loadAll(News.class);
        List<News> allNews = (List<News>) hibernateTemplate.find("from News news order by news.createDate desc");
        return allNews;
    }
}
