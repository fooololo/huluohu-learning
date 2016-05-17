package com.huluohu.learning.springmvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/17
 * Time           :   10:11
 * Description    :		配置servlet3.0+,替代web.xml
 */
public class WebInitializer implements WebApplicationInitializer {
	@Override public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		//配置注册类
		context.register(MvcConfig.class);
		context.setServletContext(servletContext);

		//注册DispatcherServlet
		ServletRegistration.Dynamic dispatcher = servletContext
				.addServlet("dispatcher", new DispatcherServlet(context));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
	}
}
