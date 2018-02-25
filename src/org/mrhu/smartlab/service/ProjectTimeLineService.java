package org.mrhu.smartlab.service;


import org.mrhu.smartlab.model.Project;
import org.mrhu.smartlab.model.ProjectTimeline;

import java.util.List;

public interface ProjectTimeLineService {

    /**
     * 持久化一个指定对象
     * @param projectTimeline 要持久化的对象
     */
    void save(ProjectTimeline projectTimeline);

    /**
     * 从数据库中获取类似的对象
     * @param exampleProjectTimeline 类似的对象
     * @return  获取到的对象
     */
    ProjectTimeline get(ProjectTimeline exampleProjectTimeline);

    /**
     * 从数据库中删除指定的对象
     * @param projectTimeline 指定的对象
     */
    void delete(ProjectTimeline projectTimeline);

    /**
     * 更新指定对象
     * @param projectTimeline 要更新的对象
     * @return 更新前的对象状态
     */
    ProjectTimeline update(ProjectTimeline projectTimeline);

    /**
     * 获取指定project下面的全部时间线
     * @param project 要获取的时间线的归属项目
     * @return 时间线组成的list
     */
    List<ProjectTimeline> getAll(Project project);
}
