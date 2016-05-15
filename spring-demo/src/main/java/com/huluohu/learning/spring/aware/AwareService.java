package com.huluohu.learning.spring.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by huluohu on 2016/5/15.
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
    private String beanName;
    private ResourceLoader resourceLoader;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("Bean的名称为:" + beanName);
        Resource resource = resourceLoader.getResource("classpath:aware/aware.txt");
        try {
            System.out.println(IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
