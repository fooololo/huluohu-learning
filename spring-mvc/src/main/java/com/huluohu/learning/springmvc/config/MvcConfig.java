package com.huluohu.learning.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/17
 * Time           :   10:02
 * Description    :
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.huluohu.learning.springmvc")
public class MvcConfig extends WebMvcConfigurerAdapter{

	/**
	 * 配置JSP视图解析器
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/classes/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}


	@Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//设置静态文件路径
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
