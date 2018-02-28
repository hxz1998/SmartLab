package org.mrhu.smartlab.filter;

import org.mrhu.smartlab.model.Status;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoFilter extends org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        HttpSession session = ((HttpServletRequest) req).getSession();
        String uri = httpServletRequest.getRequestURI();

        //如果请求路径以.go结尾
        if(uri != null && uri.endsWith(".go")) {
            String[] aUri = uri.split("/");
            if(session.getAttribute("username") == null) {
                dispatcher.forward(req, resp);
            } else {
                dispatcher = req.getRequestDispatcher(aUri[2].replaceAll(".go", ".jsp"));
            }
            if(session.getAttribute("status") == Status.USER) {
                if (aUri[2].startsWith("admin")) {
                    dispatcher.forward(req, resp);
                }
            }
            if(session.getAttribute("status") == Status.ADMINISTRATOR) {
                if(aUri[2].startsWith("user")) {
                    dispatcher.forward(req, resp);
                }
            }
        }
        super.doFilter(req, resp, chain);
    }


}
