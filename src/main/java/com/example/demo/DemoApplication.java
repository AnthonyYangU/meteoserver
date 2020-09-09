package com.example.demo;

import com.example.demo.entity.AirportDetail;
import com.example.demo.mapper.UserMapper;
//import com.example.demo.services.AirportDetailInterface;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableFeignClients
public class DemoApplication{
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
