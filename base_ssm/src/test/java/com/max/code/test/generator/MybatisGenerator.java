package com.max.code.test.generator;




import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 官网代码见：http://www.mybatis.org/generator/running/runningWithJava.html
 *
 */
public class MybatisGenerator {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("generator/generatorConfig.xml");
        /*ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);*/
        System.out.println("===============生成代码执行完毕=================");
    }

}
