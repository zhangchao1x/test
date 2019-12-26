package com.zc.tutor.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
//文件磁盘图片url 映射
//配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        //registry.addResourceHandler("/img/**").addResourceLocations("file:C:\\tutor\\src\\main\\resources\\Statics\\photos\\");
    }


}
