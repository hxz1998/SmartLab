package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.mrhu.smartlab.dispatcher.ActionRequestDispatcher;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectTimeline;
import org.mrhu.smartlab.service.ProjectService;
import org.mrhu.smartlab.service.ProjectTimeLineService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Component
@Scope("prototype")
public class EditProgressAction extends ActionSupport implements RequestAware, SessionAware{

    private String progressInfo;
    private String progressContent;
    private String progress;
    private String projectId;

    private Map<String, Object> session;
    private Map<String, Object> request;

    private ProjectService projectService;
    private ProjectTimeLineService projectTimeLineService;

    public String edit() {
        try {
            Project project = new Project();
            project.setId(projectId);
            project = projectService.get(project);
            project.setProgress(Integer.parseInt(progress));
            projectService.update(project);

            ProjectTimeline projectTimeline = new ProjectTimeline();
            projectTimeline.setInfo(progressInfo);
            projectTimeline.setContent(progressContent);
            projectTimeline.setCreateDate(new Date());
            projectTimeline.setProject(project);

            projectTimeLineService.save(projectTimeline);

            return ActionRequestDispatcher.dispatcher(session);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String getProgressInfo() {
        return progressInfo;
    }

    public void setProgressInfo(String progressInfo) {
        this.progressInfo = progressInfo;
    }

    public String getProgressContent() {
        return progressContent;
    }

    public void setProgressContent(String progressContent) {
        this.progressContent = progressContent;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Map<String, Object> getRequest() {
        return request;
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

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
