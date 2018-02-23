package org.mrhu.smartlab.service;

import org.mrhu.smartlab.model.News;

public interface NewsService {

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
    News get(News exampleNews);

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
     * 获取news对象的json表达式
     * @param news 要转换的json对象
     * @return json表达式
     */
    String getJson(News news);

    /**
     * 将全部news对象转换为json表达式
     * @return 转换后的表达式
     */
    String getAllJson();
}
