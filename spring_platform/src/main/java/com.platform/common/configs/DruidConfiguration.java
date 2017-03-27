package com.platform.common.configs;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

/**
 * Created by tanghong on 2017/2/21.
 */
@Configuration
@PropertySource("classpath:application.yml")
public class DruidConfiguration {

    @Bean(name = "dataSource")
    public DataSource druidDataSource(
        @Value("${spring.datasource.driverClassName}") String driver,
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password){
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
            druidDataSource.setDriverClassName(driver);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setInitialSize(1); // 初始化连接数
            druidDataSource.setMaxActive(20); // 最大连接数
            druidDataSource.setMinIdle(3); // 最小连接数
            druidDataSource.setMaxWait(60000); // 获取连接数的最大等待时间
            druidDataSource.setFilters("stat,wall,slf4j"); // 扩展插件配置
            druidDataSource.setPoolPreparedStatements(true); // 是否缓存statement语句,mysql5.5以下建议关闭
            druidDataSource.setMaxOpenPreparedStatements(20); // 启用psCache
            druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(33);
            druidDataSource.setMinEvictableIdleTimeMillis(300000); // 连接保持空闲而不被驱逐的最长时间
            druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
            druidDataSource.setValidationQuery("select 1"); // 检验sql
            druidDataSource.setTestWhileIdle(true); // 如果空闲时间大于 timeBetweenEvictionRunsMillis, 执行sql校验
            druidDataSource.setTimeBetweenConnectErrorMillis(30000); // 销毁线程检验连接时间,空闲时间大于等于这个时间则关闭连接
            druidDataSource.setTestOnBorrow(false); // 申请连接时,校验连接是否有效
            druidDataSource.setTestOnReturn(false); // 归还连接时,校验连接是否有效
            druidDataSource.setRemoveAbandoned(true); // 连接超时是否关闭(注意) !!!!
            druidDataSource.setLogAbandoned(true);
            druidDataSource.setConnectionInitSqls(Arrays.asList("set character set 'utf8mb4'"));
            druidDataSource.setUseGlobalDataSourceStat(true);
            //druidDataSource.setConnectionProperties("druid.stat.mergeSql=true,druid.stat.slowSqlMillis=500")
            druidDataSource.setUseGlobalDataSourceStat(true);
            // log配置
            Slf4jLogFilter logFilter = new Slf4jLogFilter();
            logFilter.setStatementExecutableSqlLogEnable(true);
            logFilter.setStatementLogErrorEnabled(true);
            logFilter.setStatementLogEnabled(true);

            // 监控配置
            StatFilter statFilter = new StatFilter();
            statFilter.setLogSlowSql(true);
            statFilter.setSlowSqlMillis(10000); // sql操作最大不能超过1分钟,一般都是毫秒级
            statFilter.setMergeSql(true);
            druidDataSource.setProxyFilters(Arrays.asList(logFilter, statFilter));
        }
        catch (Exception exe){
            exe.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        // Access address: ip:port/marketing/druid/login.html
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/marketing/druid/*");
        servletRegistrationBean.addInitParameter("allow","112.74.186.153"); // 白名单
        servletRegistrationBean.addInitParameter("deny","192.168.1.73"); // 黑名单
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/marketing/druid/*");
        return filterRegistrationBean;
    }
}
