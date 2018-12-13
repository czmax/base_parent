# jfinal 文档学习	

## 1. jfinal-undertow 下开发

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