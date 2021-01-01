package com.atguigu.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


/**
 * @Author: lzh
 * @Date: Create in 2020/9/8 20:39
 * @Description:
 */
@Configuration
public class GulimallCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter(){
        //初始化cors配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 允许跨域的域名 如果要携带cooking 不能写*
        corsConfiguration.setAllowCredentials(true); // 携带cooking？
        corsConfiguration.addAllowedHeader("*"); // 允许携带任何头信息
        corsConfiguration.addAllowedMethod("*"); // 任意方法
        // 初始化cors配置源对象
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // /** 代表所有路径都拦截
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        //返回新的CorsFilter.
        return new CorsWebFilter(urlBasedCorsConfigurationSource);
    }

}
