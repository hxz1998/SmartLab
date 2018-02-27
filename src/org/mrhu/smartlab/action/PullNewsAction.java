package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.mrhu.smartlab.dispatcher.ActionRequestDispatcher;
import org.mrhu.smartlab.model.News;
import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.service.NewsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
@Scope("prototype")
public class PullNewsAction extends ActionSupport implements RequestAware, SessionAware{

    private String newsId;
    private NewsService newsService;
    private Map<String, Object> request;
    private Map<String, Object> session;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public NewsService getNewsService() {
        return newsService;
    }

    @Resource
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public String getNewsDetail() {
        try{
            News news = new News();
            news.setId(newsId);
            News loadNews = newsService.get(news);
            request.put("newsTitle", loadNews.getTitle());
            request.put("newsId", loadNews.getId());
            request.put("pushUser", loadNews.getUser().getName());
            request.put("createDate", loadNews.getCreateDate());
            request.put("newsContent", loadNews.getContent());

            return ActionRequestDispatcher.dispatcher(session);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
