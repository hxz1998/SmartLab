package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.Project;

import java.util.List;

public interface ProjectService {

    /**
     * 持久化一个project对象
     * @param project 一个未经过持久化的对象
     */
    void save(Project project);

    /**
     * 获取一个类似实例对象的project对象
     * @param exampleProject 类似的实例对象
     * @return 查询到的对象
     */
    Project get(Project exampleProject);

    /**
     * 删除一个持久化的对象
     * @param project 要删除的对象
     */
    void delete(Project project);

    /**
     * 更新一个对象
     * @param project 要更新的对象
     * @return 返回一个load出来的对象
     */
    Project update(Project project);

    /**
     * 获取数据库中全部的project对象
     * @return  project对象构成的列表
     */
    List<Project> getAll();

    /**
     * 返回全部对象构成的数组的json表达式
     * @return 字符串形式的json表达式
     */
    String getAllJson();

    /**
     * 获取指定对象的json表达形式
     * @param project 要获取对象的实例
     * @return 指定对象的json表达式
     */
    String getJson(Project project);
}
