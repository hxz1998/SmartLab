package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogOutAction extends ActionSupport implements SessionAware{

    private Map<String, Object> session;

    @Override
    public String execute() {
        try{
            session.clear();
            return SUCCESS;
        } catch(Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
