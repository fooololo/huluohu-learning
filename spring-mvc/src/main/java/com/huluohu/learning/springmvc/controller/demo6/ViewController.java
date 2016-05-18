package com.huluohu.learning.springmvc.controller.demo6;

import com.huluohu.learning.springmvc.service.demo2.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/18
 * Time           :   11:37
 * Description    :
 */
@Controller
public class ViewController {
	@Autowired
	DemoService demoService;

	@RequestMapping("/normal")
	public String testPage(Model model){
		model.addAttribute("msg",demoService.say());
		return "page";
	}
}
