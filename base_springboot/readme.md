# base_springboot

## 1 搭建
1.1 问题
1. 修改项目名称时，如果pom文件的project标签报错，注意先不引入webjars的几个jar包
    ```xml
     <!--前端包-->
            <!-- <dependency>
                <groupId>org.webjars.npm</groupId>
                <artifactId>github-com-almasaeed2010-AdminLTE</artifactId>
                <version>${adminlte.version}</version>
            </dependency>
            <dependency>
                <groupId>org.webjars</groupId>
                <artifactId>bootstrap</artifactId>
                <version>${bootstrap.version}</version>
            </dependency>
            <dependency>
                <groupId>org.webjars.npm</groupId>
                <artifactId>bootstrap-table</artifactId>
                <version>${bootstrap-table.version}</version>
            </dependency>
    
            <dependency>
                <groupId>org.webjars.npm</groupId>
                <artifactId>jquery</artifactId>
                <version>${jquery.version}</version>
            </dependency> -->
    ```
