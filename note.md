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
    解决方法：使用```JSON.toJSONStringWithDateFormat(allNews, "yyyy-MM-dd HH:mm:ss");```
    可以解决，注意格式中大小写
4. 状况4：
    ```
    json表达式中出现循环引用
    ```
    解决方法：JSON静态方法中加入```SerializerFeature.DisableCircularReferenceDetect```参数
5. 状况5：
    el表达式相关现象
    ```
    ${request.timelines}//正确写法
    $ { 
        request.timelines
    }//错误的写法，无法解析出来
    ```
6. 状况6：
    列表到详情传递参数的时候，等号前面不能有空格。
    ```
    http://***?username=abc       ->正确写法
    http://***?username= abc      ->错误写法
    ```