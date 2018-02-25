package org.mrhu.smartlab.api.read;

import com.alibaba.fastjson.JSON;
import org.mrhu.smartlab.api.AbstractServlet;
import org.mrhu.smartlab.service.NewsService;
import org.mrhu.smartlab.util.ApiTemplateMethod;
import org.mrhu.smartlab.util.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "getNewsList",
        urlPatterns = "/api/get/news/list"
)
public class GetNewsList extends HttpServlet {

    private static NewsService newsService;

    public GetNewsList() {
        super();
        newsService = (NewsService) SpringContextUtil.getBean("newsService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    /**
     * * 统一调用方法及结果处理
     * @param request 传入的请求对象,
     *                从对象中获取请求的news对象参数
     * @param response 传入的响应对象
     * @throws IOException 抛出输出流获取失败异常
     * @throws ServletException 抛出servlet异常
     */
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ApiTemplateMethod.write(request, response, newsService.getAllJson());
    }

}
