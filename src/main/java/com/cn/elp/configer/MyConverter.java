
package com.cn.elp.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Configuration
public class MyConverter {
    private static final String DATE_TIME_FORMATE = "yyyy-MM-dd HH:mm:ss";


    @Bean
    public Converter<String, Date> convertDateTime(){
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                Date date=null;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMATE);
                if (source==null||source.equals("")){
                    date=null;
                }else {
                    try {
                        date = simpleDateFormat.parse(source);
                    } catch (ParseException e) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date=sdf.parse(source);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                return date;

            }
        } ;

    }




/*
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            //拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new Interceptor1()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html");
            }

        };
        return webMvcConfigurer;
    }
*/






}

