package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.service.ProjectService;
import org.mrhu.smartlab.service.ProjectTimeLineService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Component
@Scope("prototype")
public class PullProjectAction extends ActionSupport implements RequestAware, SessionAware{

    private String projectId;
    private ProjectService projectService;
    private Map<String, Object> session;
    private Map<String, Object> request;
    private ProjectTimeLineService projectTimeLineService;

    public String getProjectDetail() {
        try{
            Project project = new Project();
            project.setId(projectId);
            Project loadProject = projectService.get(project);

            //页面头部信息栏
            request.put("projectInfo", loadProject.getInfo());
            request.put("projectId", loadProject.getId());
            request.put("projectContent", loadProject.getContent());

            //时间轴信息栏
            request.put("timelines", projectTimeLineService.getAll(project));
            request.put("projectCreateDate", loadProject.getCreateDate());

            //底部成员信息栏
            request.put("members", loadProject.getUsers());
            request.put("", loadProject);
            if(session.get("status") == Status.ADMINISTRATOR) {
                return "admin_success";
            } else {
                return "user_success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    @Resource
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ProjectTimeLineService getProjectTimeLineService() {
        return projectTimeLineService;
    }

    @Resource
    public void setProjectTimeLineService(ProjectTimeLineService projectTimeLineService) {
        this.projectTimeLineService = projectTimeLineService;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
