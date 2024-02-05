package com.sevengod.score.interceptor;

import com.sevengod.score.conf.WebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfig {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {// 登录校验
        List<String> excludePaths = Arrays.asList("/api/wx_login", "/api/check_login");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/**").excludePathPatterns(excludePaths);
    }
}
