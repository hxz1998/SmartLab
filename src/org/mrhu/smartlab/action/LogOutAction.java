package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class LogOutAction extends ActionSupport {

    @Override
    public String execute() {
        try{
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.invalidate();
            return SUCCESS;
        } catch(Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
