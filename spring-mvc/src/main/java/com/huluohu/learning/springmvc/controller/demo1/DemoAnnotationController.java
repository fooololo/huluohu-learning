package com.huluohu.learning.springmvc.controller.demo1;

import com.huluohu.learning.springmvc.vo.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/17
 * Time           :   18:03
 * Description    :
 *	#produces:定制返回response的媒体类型和字符集
 *
 */
@Controller
@RequestMapping("/anno/")
public class DemoAnnotationController {
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request){
		return "url:" + request.getRequestURL() + "can access";
	}

	@RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request){
		return "url:" + request.getRequestURL() + "can access,str:" + str;
	}

	@RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request){
		return "url:" + request.getRequestURL() + "can access,id:" + id;
	}

	@RequestMapping(value = "/obj/json",produces = "application/json;charset=UTF-8")
	public @ResponseBody Object passObj1(DemoObj obj, HttpServletRequest request){
//		return "url:" + request.getRequestURL() + "can access,id:" + obj.getId()
//				+ " name:" + obj.getName();
		return obj;
	}
	@RequestMapping(value = "/obj/xml",produces = "application/xml;charset=UTF-8")
	public @ResponseBody Object passObj2(DemoObj obj, HttpServletRequest request){
		//		return "url:" + request.getRequestURL() + "can access,id:" + obj.getId()
		//				+ " name:" + obj.getName();
		return obj;
	}

	@RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request){
		return "url:" + request.getRequestURL() + "can access,";
	}
}
