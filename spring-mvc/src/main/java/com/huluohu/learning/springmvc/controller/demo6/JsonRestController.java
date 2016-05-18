package com.huluohu.learning.springmvc.controller.demo6;

import com.huluohu.learning.springmvc.service.demo2.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/18
 * Time           :   11:40
 * Description    :
 */
@RestController
public class JsonRestController {
	@Autowired
	DemoService demoService;

	@RequestMapping(value = "/restfull",produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public String testRest(){
		return demoService.say();
	}
}
