package net.csibio.labic.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 跨域脚本规则
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/api/**");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*") //x-requested-with,satoken
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                .allowCredentials(false).maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);

        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/login/login")
                .excludePathPatterns("/login/init");
    }

}
