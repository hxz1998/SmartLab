package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.mrhu.smartlab.dispatcher.ActionRequestDispatcher;
import org.mrhu.smartlab.model.News;
import org.mrhu.smartlab.model.User;
import org.mrhu.smartlab.service.NewsService;
import org.mrhu.smartlab.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Component
@Scope("prototype")
public class CreateNewsAction extends ActionSupport implements SessionAware {

    private String newsTitle;
    private String newsContent;

    private String newsId;

    private NewsService newsService;
    private UserService userService;
    private Map<String, Object> session;

    public String createNews() {
        try {
            User user = new User();
            News news = new News();
            user = userService.get((String) session.get("username"));
            news.setUser(user);
            news.setTitle(newsTitle);
            news.setCreateDate(new Date());
            news.setContent(newsContent);
            newsService.save(news);
            newsId = news.getId();
            return ActionRequestDispatcher.dispatcher(session);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public NewsService getNewsService() {
        return newsService;
    }

    @Resource
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }
}
