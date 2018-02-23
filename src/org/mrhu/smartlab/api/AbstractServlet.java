package org.mrhu.smartlab.api;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public AbstractServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        //让Spring进行装配bean
        SpringBeanAutowiringSupport.
                processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
    }
}
