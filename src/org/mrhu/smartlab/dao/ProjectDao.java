package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.Project;

import java.util.List;

public interface ProjectDao {

    /**
     * 持久化一个项目对象
     * @param project 要持久化的project对象
     */
    void save(Project project);

    /**
     * 从数据库中获取类似传入的project对象
     * @param exampleProject 类似的对象
     * @return 获取到的对象
     */
    Project load(Project exampleProject);

    /**
     * 从数据库中删除一个project对象
     * @param project 要删除的project对象
     */
    void delete(Project project);

    /**
     * 更新指定对象
     * @param project 要更新的对象现有状态
     * @return 更新前的状态
     */
    Project update(Project project);

    /**
     * 获取当前储存的所有project对象
     * @return 所有的project对象组成的列表
     */
    List<Project> getAll();
}
