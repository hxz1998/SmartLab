package org.mrhu.smartlab.api.read;

import org.mrhu.smartlab.service.ProjectService;
import org.mrhu.smartlab.util.ApiTemplateMethod;
import org.mrhu.smartlab.util.SpringContextUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getProjectList",
    urlPatterns = "/api/get/project/list"
)
public class GetProjectList extends HttpServlet {

    private ProjectService projectService;

    public GetProjectList() {
        super();
        projectService = (ProjectService) SpringContextUtil.getBean("projectService");
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
     *                从对象中获取请求的project对象参数
     * @param response 传入的响应对象
     * @throws IOException 抛出输出流获取失败异常
     * @throws ServletException 抛出servlet异常
     */
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ApiTemplateMethod.write(request, response, projectService.getAllJson());
    }
}
