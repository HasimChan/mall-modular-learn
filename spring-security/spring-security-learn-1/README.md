# SpringBoot 整合 Spring Security Demo 项目

参考链接：

[SpringBoot集成Spring Security](https://blog.csdn.net/yuanlaijike/article/details/80249235)

本质上是在数据库中持久化用户登录信息（账号、密码）和权限信息。通过这些信息进行登录认证和授权

问题：

怎么注册？

整合了 swagger2，但由于有spring security，所以访问在线文档需要先登录验证，后续再做更改
