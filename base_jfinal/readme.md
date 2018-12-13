@[TOC]
# jfinal 文档学习	

## 1 jfinal-undertow 下开发

http://www.jfinal.com/doc/1-2	

1. 创建maven工程，
2. 添加jar包依赖	
	```
	<dependency>
	    <groupId>com.jfinal</groupId>
	    <artifactId>jfinal-undertow</artifactId>
	    <version>1.3</version>
	</dependency>
	```		
3. 添加继承于JFinalconfig的配置类DemoConfig 	
	- 添加main方法,添加UndertowServer.start()方法调用;
	- 修改configConstant()方法，设置setdevMode为true;
	- 添加一个继承于Controller的类，HelloController，并写一个index方法;
	- 修改configRoute()方法，在Routes对象上add一个路由到HelloController;
	- 启动main方法，访问http://localhost/hello.

4. 部署后续补充
	TODO	
	
5. 代码	
	DemoConfig	
	```java	
	
	package demo;
	
	import com.jfinal.config.Constants;
	import com.jfinal.config.Handlers;
	import com.jfinal.config.Interceptors;
	import com.jfinal.config.JFinalConfig;
	import com.jfinal.config.Plugins;
	import com.jfinal.config.Routes;
	import com.jfinal.server.undertow.UndertowServer;
	import com.jfinal.template.Engine;
	
	public class DemoConfig extends JFinalConfig {
	
		public static void main(String[] args) {
			UndertowServer.start(DemoConfig.class, 80, true);
		}
	
		@Override
		public void configConstant(Constants arg0) {
			arg0.setDevMode(true);
		}
		@Override
		public void configRoute(Routes arg0) {
			arg0.add("/hello", HelloController.class);
		}
		@Override
		public void configEngine(Engine arg0) {}
		@Override
		public void configHandler(Handlers arg0) {}
		@Override
		public void configInterceptor(Interceptors arg0) {}
		@Override
		public void configPlugin(Plugins arg0) {}
	}
	
	```	
	HelloController	
	```java
	package demo;
	import com.jfinal.core.Controller;
	 
	public class HelloController extends Controller {
	    public void index() {
	       renderText("Hello JFinal World.");
	    }
	}
	
	```
## 2 JFinalConfig	
基于JFinal的web项目需要创建一个继承自JFinalConfig类的子类，该类用于对整个web项目进行配置。JFinalConfig子类需要实现六个抽象方法，如下所示：	

```java
public class DemoConfig extends JFinalConfig {
    public void configConstant(Constants me) {}
    public void configRoute(Routes me) {}
    public void configEngine(Engine me) {}
    public void configPlugin(Plugins me) {}
    public void configInterceptor(Interceptors me) {}
    public void configHandler(Handlers me) {}
}
```     


Routes.setBaseViewPath(baseViewPath)方法用于为该Routes 内部的所有Controller设置视图渲染时的基础路径，该基础路径与Routes.add(…, viewPath)方法传入的viewPath以及 Controller.render(view) 方法传入的 view 参数联合组成最终的视图路径，规则如下：	
finalView = baseViewPath + viewPath + view
注意：当view以 “/” 字符打头时表示绝对路径，baseViewPath 与 viewPath 将被忽略。

JFinal路由规则如下表：	
![image](http://www.jfinal.com/upload/img/document/0/1_20180112225146.png)

## 3 Controller
getPara使用例子：
![image](http://www.jfinal.com/upload/img/document/0/1_20180112235732.png)
