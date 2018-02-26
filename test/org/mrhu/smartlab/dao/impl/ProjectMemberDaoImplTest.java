package org.mrhu.smartlab.dao.impl; 

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectMemberDuty;
import org.mrhu.smartlab.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/** 
* ProjectMemberDaoImpl Tester. 
* 
* @author mrhu 
* @since <pre>02/25/2018</pre> 
* @version 1.0 
*/ 
public class ProjectMemberDaoImplTest { 


    @Test
    public void testGetSetHibernateTemplate() throws Exception { 
    }


    @Test
    public void testGetAllMemberAndDuty() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProjectMemberDutyDaoImpl projectMemberDao = (ProjectMemberDutyDaoImpl) applicationContext.getBean("projectMemberDutyDao");
        Project project = new Project();
        project.setId("402881e961cd650e0161cd655b560003");
        System.out.println(projectMemberDao.getAllMemberAndDutyToJson(project));

    }


} 
