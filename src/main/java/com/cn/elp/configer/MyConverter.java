/*

package com.cn.elp.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Configuration
public class MyConverter {
    private static final String DATE_TIME_FORMATE = "yyyy-MM-dd";


    @Bean
    public Converter<String, Date> convertDateTime(){
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                Date date=null;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                try {
                    date = simpleDateFormat.parse(source);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        } ;

    }
}

*/
