package org.mrhu.smartlab.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ApiTemplateMethod {

    /**
     * 模板方法，用来向外输出请求的json表达式
     * @param request 请求对象
     * @param response 响应对象
     * @param json 要写入的json表达式
     * @throws IOException 如果获取输出流失败抛出异常
     */
    public static void write(HttpServletRequest request, HttpServletResponse response, String json) throws IOException{
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
