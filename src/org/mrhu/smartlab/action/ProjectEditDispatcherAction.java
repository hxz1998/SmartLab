package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.mrhu.smartlab.dispatcher.ActionRequestDispatcher;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.service.ProjectService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
@Scope("prototype")
public class ProjectEditDispatcherAction extends ActionSupport implements RequestAware, SessionAware{

    private String projectId;
    private Map<String, Object> request;
    private Map<String, Object> sesison;
    private ProjectService projectService;

    public String dispatcher() {
        try {
            Project project = new Project();
            project.setId(projectId);
            project = projectService.get(project);
            request.put("projectName", project.getInfo());
            request.put("projectId", project.getId());
            request.put("projectManager", project.getPmUser().getName());
            return ActionRequestDispatcher.dispatcher(sesison);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public Map<String, Object> getSesison() {
        return sesison;
    }


    public void setSesison(Map<String, Object> sesison) {
        this.sesison = sesison;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    @Resource
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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
        this.sesison = session;
    }
}
