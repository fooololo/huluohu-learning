package com.huluohu.learning.spring.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by huluohu on 2016/5/15.
 */
@Configuration
@ComponentScan("com.huluohu.learning.spring.el")
@Component
//指定注入的配置文件
@PropertySource(value = {"classpath:el/el.properties"},ignoreResourceNotFound = true)
public class ElConfig {
    @Value("I Love you")
    private String nomal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    @Value("#{demoService.author}")
    private String fromAuthor;

    @Value("classpath:el/aware.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    //使用$而不是#
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    @Bean
    //让spring正确解析出${} 中的值
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(nomal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAuthor);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
