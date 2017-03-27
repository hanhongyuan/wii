package com.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by tanghong on 2017/2/20.
 */
@SpringBootApplication
@MapperScan("com.platform.web.mapper")
@ImportResource("classpath:spring/spring-context.xml")
public class Application {

    @Bean
    public DispatcherServlet dispatchServlet(){
        return new DispatcherServlet();
    }

    @Bean
    public  ServletRegistrationBean dispatcherServletRegistration(){
        ServletRegistrationBean srt = new ServletRegistrationBean(dispatchServlet(), "/platform/*");
        srt.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return srt;
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
