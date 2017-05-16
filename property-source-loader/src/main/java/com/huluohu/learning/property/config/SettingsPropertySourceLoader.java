package com.huluohu.learning.property.config;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by Administrator on 2017/5/16.
 */
public class SettingsPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[0];
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        return null;
    }
}
