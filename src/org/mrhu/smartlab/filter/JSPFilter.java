package org.mrhu.smartlab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JSPFilter extends org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        HttpSession session = ((HttpServletRequest) req).getSession();
        String uri = httpServletRequest.getRequestURI();
        if(uri != null && uri.endsWith(".jsp")) {
            if(session.getAttribute("username") == null) {
                dispatcher.forward(req, resp);
            }
        }
        super.doFilter(req, resp, chain);
    }


}
