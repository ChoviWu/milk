package com.xw.milk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.xw.milk.mapper")
@ComponentScan(basePackages = {"com.xw.milk.config","com.xw.milk.service"})
@EnableScheduling//创建启动定时任务
public class Application {



	public static void main(String[] args) {
		//热部署开关:true表示开启,false表示关闭
		System.setProperty("spring.devtools.restart.enabled","true");
		SpringApplication.run(Application.class, args);

		System.out.println("-------+=========\n\nStart...\n\n===============");
	}



	}
