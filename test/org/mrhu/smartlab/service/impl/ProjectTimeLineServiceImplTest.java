package org.mrhu.smartlab.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.service.ProjectTimeLineService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* ProjectTimeLineServiceImpl Tester. 
* 
* @author mrhu 
* @since <pre>02/26/2018</pre> 
* @version 1.0 
*/ 
public class ProjectTimeLineServiceImplTest { 


    @Test
    public void testGetSetProjectTimeLineDao() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testSave() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testGet() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testDelete() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testUpdate() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testGetAll() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testGetAllToJson() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProjectTimeLineService service = (ProjectTimeLineService) applicationContext.getBean("projectTimeLineService");
        Project project = new Project();
        project.setId("402881e961cd650e0161cd655b560003");
        String json = service.getAllToJson(project);
        System.out.println(json);
    }


} 
