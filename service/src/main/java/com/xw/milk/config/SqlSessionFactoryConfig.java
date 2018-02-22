package com.xw.milk.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 配置Mapper
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class SqlSessionFactoryConfig {

    @Autowired
    protected DataSource dataSource;
    //mybatis配置
    private static String Mybatis_Config = "mybatis-config.xml";
    //类的别名
    private static String ALIASMODEL = "com.example.model";

    private static String MAPPERXMLPATH = "mapper/*.xml";

    Logger LOG = LoggerFactory.getLogger("SqlSessionFactoryConfig");

    /**
     * Mapper
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    public  SqlSessionFactory sqlSessionFactoryBean(
           DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        try {
            this.dataSource = dataSource;
            sqlSessionFactory.setDataSource(dataSource);
            //设置mybatis
            sqlSessionFactory.setConfigLocation(new ClassPathResource(Mybatis_Config));
            //设置模型类别名
            sqlSessionFactory.setTypeAliasesPackage(ALIASMODEL);
            //添加XML目录
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            //*.mapper.xml的地址（根据你的项目自行修改）
            sqlSessionFactory.setMapperLocations(resolver.getResources(MAPPERXMLPATH));
            //设置mapper sql文件的扫描路径
            return sqlSessionFactory.getObject();

         } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 注入数据源
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }

//    /**
//     * 初始化sql文件  注入sql
//     * @param dataSource
//     * @return
//     */
//    @Bean
//    public Object initDataBase(DataSource dataSource){
//
//        ClassPathResource recordsSys = new ClassPathResource("scm-records-sys.sql");
//
//
//        DataSourceInitializer init = new DataSourceInitializer();
//        dataSource = this.dataSource;
//        init.setDataSource(dataSource);
//        init.setDataSource(dataSource);
//        init.setDatabasePopulator(new ResourceDatabasePopulator(true, true, "utf-8", recordsSys));
//        init.setEnabled(true);
//        return init;
//    }



}
