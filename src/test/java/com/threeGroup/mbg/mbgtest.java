package com.threeGroup.mbg;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class mbgtest {
    @Test
    public void test1() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        System.out.println(configFile);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        System.out.println(myBatisGenerator);
        System.out.println("我执行了吗");
        myBatisGenerator.generate(null);
    }
    @Test
    public void test2(){
        String str = "duo2B";
        System.out.println(str.substring(3,str.length()-1));
        System.out.println(Integer.parseInt(str.substring(3,str.length()-1)));
    }
}
