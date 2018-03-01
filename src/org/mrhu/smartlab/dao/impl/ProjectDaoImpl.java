package org.mrhu.smartlab.dao.impl;

import org.mrhu.smartlab.dao.ProjectDao;
import org.mrhu.smartlab.model.Project;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("projectDao")
public class ProjectDaoImpl implements ProjectDao {

    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(Project project) {
        hibernateTemplate.save(project);
    }

    @Override
    public Project load(Project exampleProject) {
        return hibernateTemplate.get(Project.class, exampleProject.getId());
    }

    @Override
    public void delete(Project project) {
        hibernateTemplate.delete(project);
    }

    @Override
    public Project update(Project project) {
        Project before = hibernateTemplate.load(Project.class, project.getId());
        hibernateTemplate.update(project);
        return before;
    }

    @Override
    public List<Project> getAll() {
//        return hibernateTemplate.loadAll(Project.class);
        return (List<Project>) hibernateTemplate.find("from Project project order by project.createDate desc");
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
