package com.xw.milk.tools;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-8-10.
 */
public class GeneratorMapper {


    @Test
   public  void test( ) throws Exception {
       List<String> warnings = new ArrayList<String>();
       boolean overwrite = true;
       ConfigurationParser cp = new ConfigurationParser(warnings);
       Configuration config = cp.parseConfiguration(
               GeneratorMapper.class.getResourceAsStream("/generatorConfig.xml"));
       Context context=config.getContext("Mysql");
       List<TableConfiguration> configs= context.getTableConfigurations();
       for(TableConfiguration c:configs){
           c.setCountByExampleStatementEnabled(false);
           c.setUpdateByExampleStatementEnabled(false);
           c.setUpdateByPrimaryKeyStatementEnabled(false);
           c.setDeleteByExampleStatementEnabled(false);
           c.setSelectByExampleStatementEnabled(false);
       }
       DefaultShellCallback callback = new DefaultShellCallback(overwrite);
       MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
       myBatisGenerator.generate(null);

   }
}
