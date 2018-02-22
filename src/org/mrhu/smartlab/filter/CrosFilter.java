package org.mrhu.smartlab.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws ServletException, IOException{
        HttpServletResponse response = (HttpServletResponse) rep;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, accept, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(req, rep);
    }
}
