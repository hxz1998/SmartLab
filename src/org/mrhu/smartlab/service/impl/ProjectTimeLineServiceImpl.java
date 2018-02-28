package org.mrhu.smartlab.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.mrhu.smartlab.dao.ProjectTimeLineDao;
import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectTimeline;
import org.mrhu.smartlab.service.ProjectTimeLineService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component("projectTimeLineService")
@Transactional
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

    @Override
    public String getAllToJson(Project project) {
        return JSON.toJSONStringWithDateFormat(getAll(project), "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
    }
}
