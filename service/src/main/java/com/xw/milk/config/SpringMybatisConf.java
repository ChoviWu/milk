package com.xw.milk.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
@ConditionalOnClass(SqlSessionFactoryConfig.class)
public class SpringMybatisConf {

    private static String MAPPERPATH = "com.example.mapper";

//    private static String SQLSESSIONBEAN = "sqlSessionFactory";

    /**
     * Spring Mapper整合
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //*.mapper(*.dao)的包名（根据你的项目自行修改）
        mapperScannerConfigurer.setBasePackage(MAPPERPATH);
        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        //tk.mybatis.mapper.common.Mapper
        properties.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        properties.setProperty("notEmpty", "false");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        //使用的数据库类型名称（MySQL,Oracle,Postgresql...）
        properties.setProperty("IDENTITY", "MySQL");//
        mapperScannerConfigurer.setAddToConfig(true);
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
