package com.xiumu.country_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 岐神~汤圆
 * @Description:  关于拦截器的配置
 * @Attention:
 * @date: 2021/3/1 19:03
 * @version:1.0
 */
/*
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(countryManagerInterceptor())
                .addPathPatterns("/**");
    }
    //@Bean
    public CountryManagerInterceptor countryManagerInterceptor() {
        return new CountryManagerInterceptor();
    }
}//大佬原有的
*/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {


        registry.addMapping("/**")//预访问路径
                .allowedOriginPatterns("*")//请求来源.allowedOrigins("http://localhost:8080","null")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")// 方法
                .allowCredentials(true)// 允许携带
                .maxAge(3600)//   最大时间
                .allowedHeaders("*");

    }
}//解决跨域问题  全局配置类，配置跨域请求   新加的解决跨域问题---lmy