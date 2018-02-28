package org.mrhu.smartlab.service.impl;

import org.mrhu.smartlab.dao.ProjectMemberDutyDao;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectMemberDuty;
import org.mrhu.smartlab.service.ProjectMemberDutyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component("projectMemberDutyService")
@Transactional
public class ProjectMemberDutyServiceImpl implements ProjectMemberDutyService {

    private ProjectMemberDutyDao projectMemberDutyDao;

    public ProjectMemberDutyDao getProjectMemberDutyDao() {
        return projectMemberDutyDao;
    }

    @Resource
    public void setProjectMemberDutyDao(ProjectMemberDutyDao projectMemberDutyDao) {
        this.projectMemberDutyDao = projectMemberDutyDao;
    }

    @Override
    public void save(ProjectMemberDuty projectMemberDuty) {
        projectMemberDutyDao.save(projectMemberDuty);
    }

    @Override
    public String getAllDetailToJson(Project project) {
        if(project != null) {
            return projectMemberDutyDao.getAllMemberAndDutyToJson(project);
        } else {
            return null;
        }
    }
}
