package org.mrhu.smartlab.dao.impl;

import org.mrhu.smartlab.dao.ProjectTimeLineDao;
import org.mrhu.smartlab.model.ProjectTimeline;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("projectTimeLineDao")
public class ProjectTimeLineDaoImpl implements ProjectTimeLineDao{

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(ProjectTimeline projectTimeline) {
        hibernateTemplate.save(projectTimeline);
    }

    @Override
    public ProjectTimeline load(ProjectTimeline exampleProjectTimeline) {
        return hibernateTemplate.get(ProjectTimeline.class, exampleProjectTimeline.getId());
    }

    @Override
    public void delete(ProjectTimeline projectTimeline) {
        hibernateTemplate.delete(projectTimeline);
    }

    @Override
    public ProjectTimeline update(ProjectTimeline projectTimeline) {
        ProjectTimeline before = hibernateTemplate.load(ProjectTimeline.class, projectTimeline.getId());
        hibernateTemplate.update(projectTimeline);
        return before;
    }

    @Override
    public List<ProjectTimeline> loadByProjectId(String projectID) {
        List<ProjectTimeline> projectTimelines = (List<ProjectTimeline>) hibernateTemplate.find("from ProjectTimeline p where p.project.id = ?", projectID);
        return projectTimelines;
    }
}
