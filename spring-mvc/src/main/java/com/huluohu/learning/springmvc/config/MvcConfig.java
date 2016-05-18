package com.huluohu.learning.springmvc.config;

import com.huluohu.learning.springmvc.core.converter.MyMessageConverter;
import com.huluohu.learning.springmvc.core.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/17
 * Time           :   10:02
 * Description    :
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("com.huluohu.learning.springmvc")
public class MvcConfig extends WebMvcConfigurerAdapter{

	/**
	 * 创建拦截器
	 * @return
     */
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}

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

	/**
	 * 文件上传
	 * @return
	 */
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

	/**
	 * 自定义转换器
	 * @return
	 */
	@Bean
	public MyMessageConverter myMessageConverter(){
		return new MyMessageConverter();
	}

	/**
	 * 注册拦截器
	 * @param registry
     */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}

	/**
	 * 设置静态文件路径
	 * @param registry
     */
	@Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	/**
	 * 配置页面跳转
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//设置页面跳转简单写法
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/upload").setViewName("/upload");

		registry.addViewController("/converter").setViewName("/converter");
		registry.addViewController("/sse").setViewName("/sse");
		registry.addViewController("/async").setViewName("/async");
	}

	/**
	 * 配置请求路径相关
	 * @param configurer
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		//如果参数中包含".",不忽略
		configurer.setUseSuffixPatternMatch(false);
	}

	/**
	 * 扩展消息类型
	 * @param converters
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(myMessageConverter());
	}
}
