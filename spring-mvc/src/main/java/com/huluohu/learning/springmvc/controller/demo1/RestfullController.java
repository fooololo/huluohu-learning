package com.huluohu.learning.springmvc.controller.demo1;

import com.huluohu.learning.springmvc.vo.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/17
 * Time           :   17:54
 * Description    :
 */
@RestController
@RequestMapping("/rest/")
public class RestfullController {

	@RequestMapping(value = "json",produces = {"application/json;charset=UTF-8"})
	public DemoObj json(){
		return new DemoObj(12L,"JSON");
	}

	@RequestMapping(value = "xml",produces = {"application/xml;charset=UTF-8"})
	public DemoObj xml(){
		return new DemoObj(12L,"XML");
	}
}
