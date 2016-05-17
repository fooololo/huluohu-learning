package com.huluohu.learning.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/17
 * Time           :   10:15
 * Description    :
 */
@Controller
public class HelloController {
	@RequestMapping("/index")
	public String hello(){
		return "index";
	}
}
