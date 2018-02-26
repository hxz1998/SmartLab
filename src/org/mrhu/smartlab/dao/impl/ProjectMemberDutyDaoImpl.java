package org.mrhu.smartlab.dao.impl;

import com.alibaba.fastjson.JSON;
import org.mrhu.smartlab.dao.ProjectMemberDutyDao;
import org.mrhu.smartlab.dto.ProjectMemberDutyDto;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Component("projectMemberDutyDao")
public class ProjectMemberDutyDaoImpl implements ProjectMemberDutyDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 将指定项目下面的所有成员信息调取出来
     * @param project 指定的项目
     * @return 由项目组成员信息组成的json表达式
     */
    @Override
    public String getAllMemberAndDutyToJson(Project project) {
        List<User> users = (List<User>) hibernateTemplate.find("select tagert.user from ProjectMemberDuty tagert where tagert.project = ?", project);
        List<ProjectMemberDutyDto> projectMemberDutyDtos = new ArrayList<>();
        for(int index = 0;index < users.size();index++) {
            ProjectMemberDutyDto dto = new ProjectMemberDutyDto();
            dto.setName(users.get(index).getName());
            dto.setContact(users.get(index).getContact());
            //前端页面中年级那一列删除掉
            dto.setStartTime(users.get(index).getStart().toString());
            String duty = (String) hibernateTemplate
                    .find("select target.describe from ProjectMemberDuty target where target.user = ?"
                            , users.get(index)).get(0);
            dto.setDuty(duty);
            projectMemberDutyDtos.add(dto);
        }
        return JSON.toJSONStringWithDateFormat(projectMemberDutyDtos, "yyyy-MM-dd HH:mm:ss");
    }
}
