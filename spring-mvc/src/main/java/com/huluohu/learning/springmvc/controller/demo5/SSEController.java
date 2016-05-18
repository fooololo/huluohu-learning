package com.huluohu.learning.springmvc.controller.demo5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/18
 * Time           :   9:34
 * Description    : Server Send Event (SSE)实现服务端推送
 */
@Controller
public class SSEController {

	@ResponseBody
	@RequestMapping(value = "push",produces = "text/event-stream")
	public String push(){
		Random random = new Random();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//输出报文需要以“data:”开头，且以“\n\n”结尾
		return "data:Testing 1,2,3:" + random.nextInt() + "\n\n";
	}
}
