package org.mrhu.smartlab.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.mrhu.smartlab.dispatcher.ActionRequestDispatcher;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectMemberDuty;
import org.mrhu.smartlab.model.User;
import org.mrhu.smartlab.service.ProjectMemberDutyService;
import org.mrhu.smartlab.service.ProjectService;
import org.mrhu.smartlab.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Component
@Scope("prototype")
public class CreateProjectAction extends ActionSupport implements SessionAware, RequestAware{

    private Map<String, Object> session;
    private Map<String, Object> request;
    private String projectInfo;
    private String projectContent;
    private String result;
    private String projectId;

    private ProjectService projectService;
    private UserService userService;
    private ProjectMemberDutyService projectMemberDutyService;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String createProject() {
        try {
            User user = new User();
            user = userService.get((String) session.get("username"));
            Project project = new Project();
            project.setProgress(0);
            project.setPmUser(user);
            project.setCreateDate(new Date());
            project.setContent(projectContent);
            Set<User> users = new HashSet<>();
            users.add(user);
            project.setUsers(users);
            project.setInfo(projectInfo);

            projectService.save(project);
            project = projectService.get(project);
            projectId = project.getId();
            ProjectMemberDuty duty = new ProjectMemberDuty();
            duty.setDescribe("创建者");
            duty.setProject(project);
            duty.setUser(user);
            projectMemberDutyService.save(duty);
            result = "创建项目成功";
            return ActionRequestDispatcher.dispatcher(session);
        } catch (Exception e) {
            e.printStackTrace();
            result = "创建项目失败";
            return ERROR;
        }
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public ProjectMemberDutyService getProjectMemberDutyService() {
        return projectMemberDutyService;
    }

    @Resource
    public void setProjectMemberDutyService(ProjectMemberDutyService projectMemberDutyService) {
        this.projectMemberDutyService = projectMemberDutyService;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    @Resource
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
