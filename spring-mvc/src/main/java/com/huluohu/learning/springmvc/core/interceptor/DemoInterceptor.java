package com.huluohu.learning.springmvc.core.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/17
 * Time           :   18:51
 * Description    :		定义拦截器
 */
public class DemoInterceptor extends HandlerInterceptorAdapter{
	/**
	 * controller方法执行前
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime",startTime);
		return super.preHandle(request, response, handler);
	}

	/**
	 * controller方法执行完但尚未返回
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		long startTime = (long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long handingTine = endTime - startTime;
		System.out.println("本次请求处理时间为：" + handingTine + " ms");
		request.setAttribute("handingTime",handingTine);
	}

	/**
	 * controller方法执行完且返回
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
