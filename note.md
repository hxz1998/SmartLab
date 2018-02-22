# 开发笔记
---
1. 报错：
    ```
    a different object with the same identifier value was already associated with the session
    ```
    解决方法：在DAO层将update对象中的hibernateTemplate所用get方法改为load方法