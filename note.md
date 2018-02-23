# 开发笔记
---
1. 状况1：
    ```
    a different object with the same identifier value was already associated with the session
    ```
    解决方法：在DAO层将update对象中的hibernateTemplate所用get方法改为load方法
2. 状况2：
    ```
    用Spring管理servlet，前端页面报500后刷新报404
    ```
    解决方法：servlet中使用的service初始化未成功，采用方案：硬编码方式写一个SpringContextUtil类直接获取相应service，然后在servlet构造方法中初始化
3. 状况3：
    ```
    fastjson关于时间的序列化问题，出现非通用时间格式、时不是24小时制
    ```
    解决方法：使用
    ```
    JSON.toJSONStringWithDateFormat(allNews, "yyyy-MM-dd HH:mm:ss");
    ```
    可以解决，注意格式中大小写
    