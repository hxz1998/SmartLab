package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.mrhu.smartlab.model.ProjectTimeline;

import java.util.List;
import java.util.Map;

public class PullProjectTimeLineAction extends ActionSupport implements SessionAware, RequestAware {

    private String projectId;
    private Map<String, Object> session;
    private Map<String, Object> request;
    private List<ProjectTimeline> projectTimelineLists;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public List<ProjectTimeline> getProjectTimelineLists() {
        return projectTimelineLists;
    }

    public void setProjectTimelineLists(List<ProjectTimeline> projectTimelineLists) {
        this.projectTimelineLists = projectTimelineLists;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getAllProjectTimeLine(){
        return SUCCESS;
    }

}
