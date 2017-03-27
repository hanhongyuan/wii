package com.platform.common.configs;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by tanghong on 2017/2/21.
 */
@SuppressWarnings("ALL")
@Configuration
public class MybatisConfig {
    @Autowired
    DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean session = new SqlSessionFactoryBean();
        try {
            session.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            session.setMapperLocations(resolver.getResources("classpath:sqlMap/*.xml"));
            //session.setPlugins(Array(new PageInterceptor))
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }
}
