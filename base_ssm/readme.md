# 基于spring的4SSM基础项目
## 1 搭建

fastjson的问题
解决返回JSON时报错：No converter found for return value of type:    

https://blog.csdn.net/Li_born/article/details/79597448

https://blog.csdn.net/cuihaiyang/article/details/78391851
## 2 通用Mapper


参考：

https://blog.csdn.net/bushqiang/article/details/80022820

mybatis-generator:generate
https://blog.csdn.net/bushqiang/article/details/79764627

https://blog.csdn.net/qq_37939251/article/details/82916028#1.2%20Spring%20%E9%9B%86%E6%88%90

aop事务，需要添加包 aspectjweaver.version，否则报错

 Failed to introspect bean class [org.springframework.aop.aspectj.AspectJExpressionPointcut]
 
 如何提取接口
 
 https://www.jianshu.com/p/041e0f1fa3a9
 
 
 遇到的问题。
 1. 自定义mapper不能放到`mapperScannerConfigurer.setBasePackage`的包下，否则会报错`ClassCastException`
 2. test报错
    在tomcat中运行没有问题，但是使用springboot 的JUnit进行单元测试时报错。这是由于在test class中添加了@value("${..}"),这需要需要添加el-api和它的实现的支持，而在tomcat中是有这两个jar包的，解决方案，在pom中添加如下依赖即可。

    https://blog.csdn.net/seven_zhao/article/details/78902114
 
 3. test报错  
    ```Error creating bean with name 'documentationPluginsBootstrapper' ```     
    因为引入swagger的缘故，在测试类上加上 和 @WebAppConfiguration 两个注解，就可以了
 ## 3 shiro加上redis
 
 参考：
 SSM框架+shiro+redis的基础框架，有助于新手学习
 
 https://blog.csdn.net/ran_Max/article/details/80619762#commentBox
 
 https://github.com/xhwanhaoran/ssm/tree/8baf68f79395bb5f1062b8b4538d6ac16936216f
 
 Shiro Demo 准备工作
 
 https://www.sojson.com/shiro