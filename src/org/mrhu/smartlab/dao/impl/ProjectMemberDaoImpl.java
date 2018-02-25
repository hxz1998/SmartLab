package org.mrhu.smartlab.dao.impl;

import org.mrhu.smartlab.dao.ProjectMemberDao;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectMemberDuty;
import org.mrhu.smartlab.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component("projectMemberDao")
public class ProjectMemberDaoImpl implements ProjectMemberDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Map<User, ProjectMemberDuty> getAllMemberAndDuty(Project project) {
        Project loadProject = hibernateTemplate.get(Project.class, project.getId());
        List<ProjectMemberDuty> projectMemberDuties = (List<ProjectMemberDuty>) hibernateTemplate
                .find("from ProjectMemberDuty p where p.project = ?", project);
        Set<User> users = loadProject.getUsers();
        Map<User, ProjectMemberDuty> map = new HashMap<>();
        for(User user : users) {
            ProjectMemberDuty duty = new ProjectMemberDuty();
            for(int iterator = 0;iterator < projectMemberDuties.size();iterator++) {
                if(projectMemberDuties.get(iterator).getUser().getId().equals(user.getId())) {
                    duty = projectMemberDuties.get(iterator);
                    break;
                }
            }
            map.put(user, duty);
        }
        return map;
    }
}
