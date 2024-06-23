package com.code;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.code.util.CommonUtils;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;
import java.util.Properties;


//mybatis 分页插件 参数配置

@Configuration
@EnableTransactionManagement
@MapperScan("com.code.mapper")
public class PageHelperConfig {

    //设置项目所有资源跨域
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //允许任何域名
        corsConfiguration.addAllowedHeader("*"); //允许任何头
        corsConfiguration.addAllowedMethod("*"); //允许任何方法
        source.registerCorsConfiguration("/**",corsConfiguration); //注册
        return new CorsFilter(source);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor page = new PerformanceInterceptor();
        page.setFormat(true);
        return page;
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper() throws Exception {
        PageHelper pageHelper = new PageHelper();
        if (CommonUtils.checkCode()) {
            Properties properties = new Properties();
            properties.setProperty("offsetAsPageNum", "true");
            properties.setProperty("rowBoundsWithCount", "true");
            properties.setProperty("reasonable", "true");
            properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
            pageHelper.setProperties(properties);
        }
        return pageHelper;
    }

    /**
     * 显示springboot项目启动访问地址
     *
     * @return
     */
    public static void showStartInfo() {
        try {
            //加载属性文件，读取数据库连接配置信息
            Properties pro = new Properties();
            try {
                pro.load(PageHelperConfig.class.getResourceAsStream("/application.properties"));
                String server_port = pro.getProperty("server.port");
                String context_path = pro.getProperty("server.servlet.context-path");
                //String url = "http://localhost:" + server_port + context_path + "/index";
                //启动vue批处理命令
//                String userDir = System.getProperty("user.dir");
//                Process process = Runtime.getRuntime().exec("cmd /c start   " + userDir + "/vue-mooc/点我启动VUE项目.bat");
                String url = "http://localhost:3000/";
                Runtime.getRuntime().exec("cmd /c start " + url);  // 启动浏览器
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("未找到配置文件！！！" + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
