package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.News;

import java.util.List;

public interface NewsDao {

    /**
     * 持久化一个指定对象
     * @param news 要持久化的对象
     */
    void save(News news);

    /**
     * 从数据库中获取类似的对象
     * @param exampleNews 类似的对象
     * @return  获取到的对象
     */
    News load(News exampleNews);

    /**
     * 从数据库中删除指定的对象
     * @param news 指定的对象
     */
    void delete(News news);

    /**
     * 更新指定对象
     * @param news 要更新的对象
     * @return 更新前的对象状态
     */
    News update(News news);

    /**
     * 获取所有对象
     * @return 所有的对象构成的列表
     */
    List<News> getAll();
}
