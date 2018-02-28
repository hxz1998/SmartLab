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
7. 防止用户直接访问jsp页面
    解决方法：继承```org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter```，然后手写处理逻辑
    ```
    public class JSPFilter extends org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter {
    
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            HttpSession session = ((HttpServletRequest) req).getSession();
            String uri = httpServletRequest.getRequestURI();
    
            //如果请求路径以.jsp结尾，且不是注册页面（register.jsp）,将请求重定向到登录界面
            if(uri != null && uri.endsWith(".jsp") && !uri.endsWith("register.jsp")) {
                if(session.getAttribute("username") == null) {
                    dispatcher.forward(req, resp);
                }
            }
            //最后调用struts2的处理
            super.doFilter(req, resp, chain);
        }
    
    }
    ```
    然后在web.xml配置文件中配置使用过滤器
    ```
    <!--防止用户直接访问jsp文件-->
    <filter>
        <filter-name>JSPFilter</filter-name>
        <filter-class>org.mrhu.smartlab.filter.JSPFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>JSPFilter</filter-name>
        <url-pattern>*.jsp</url-pattern>
    </filter-mapping>
    ```
    