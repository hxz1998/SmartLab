package org.mrhu.smartlab.api.read;

import com.alibaba.fastjson.JSON;
import org.mrhu.smartlab.api.AbstractServlet;
import org.mrhu.smartlab.service.NewsService;
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


@WebServlet(name = "getnewslist",
        urlPatterns = "/api/get/news/list"
)
public class getNewsList extends HttpServlet {

    private static NewsService newsService;

    public getNewsList() {
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
     * 统一调用方法及结果处理
     * @param request 传入的请求对象,
     *                从对象中获取请求的news对象参数
     * @param response 传入的响应对象
     */
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String json = JSON.toJSONString(newsService.getAllJson());
        PrintWriter out = response.getWriter();
        json = json.replace("\\", "");
        StringBuilder stringBuilder = new StringBuilder(json);
        json = stringBuilder.replace(0, 2, "").toString();
        json = stringBuilder.replace(json.length() - 2, json.length(), "").toString();
        System.out.println(json);
        out.write(json);
        out.flush();
        out.close();
    }

}
