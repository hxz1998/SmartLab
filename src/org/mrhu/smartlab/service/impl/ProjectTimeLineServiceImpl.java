package org.mrhu.smartlab.service.impl;

import org.mrhu.smartlab.dao.ProjectTimeLineDao;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectTimeline;
import org.mrhu.smartlab.service.ProjectTimeLineService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("projectTimeLine")
public class ProjectTimeLineServiceImpl implements ProjectTimeLineService {

    private ProjectTimeLineDao projectTimeLineDao;

    public ProjectTimeLineDao getProjectTimeLineDao() {
        return projectTimeLineDao;
    }

    @Resource
    public void setProjectTimeLineDao(ProjectTimeLineDao projectTimeLineDao) {
        this.projectTimeLineDao = projectTimeLineDao;
    }

    @Override
    public void save(ProjectTimeline projectTimeline) {
        projectTimeLineDao.save(projectTimeline);
    }

    @Override
    public ProjectTimeline get(ProjectTimeline exampleProjectTimeline) {
        return projectTimeLineDao.load(exampleProjectTimeline);
    }

    @Override
    public void delete(ProjectTimeline projectTimeline) {
        projectTimeLineDao.delete(projectTimeline);
    }

    @Override
    public ProjectTimeline update(ProjectTimeline projectTimeline) {
        return projectTimeLineDao.update(projectTimeline);
    }

    @Override
    public List<ProjectTimeline> getAll(Project project) {
        return projectTimeLineDao.loadByProjectId(project.getId());
    }
}
