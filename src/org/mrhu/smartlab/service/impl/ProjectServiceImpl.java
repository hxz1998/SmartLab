package org.mrhu.smartlab.service.impl;

import com.alibaba.fastjson.JSON;
import org.mrhu.smartlab.dao.ProjectDao;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.service.ProjectService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    public ProjectDao getProjectDao() {
        return projectDao;
    }

    @Resource
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void save(Project project) {
        if(project != null) {
            projectDao.save(project);
        }
    }

    @Override
    public Project get(Project exampleProject) {
        if(exampleProject != null && exampleProject.getId()!= null) {
            return projectDao.load(exampleProject);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Project project) {
        projectDao.delete(project);
    }

    @Override
    public Project update(Project project) {
        return projectDao.update(project);
    }

    @Override
    public List<Project> getAll() {
        return projectDao.getAll();
    }

    @Override
    public String getAllJson() {
        return JSON.toJSONStringWithDateFormat(getAll(), "yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public String getJson(Project project) {
        return JSON.toJSONStringWithDateFormat(get(project), "yyyy-MM-dd HH:mm:ss");
    }

}
