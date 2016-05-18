package com.huluohu.learning.springmvc.controller.demo5;

import com.huluohu.learning.springmvc.service.demo1.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/18
 * Time           :   9:54
 * Description    :		使用servlet3.0+的异步方法实现推送
 */
@Controller
public class ServletAsyncController {
	@Autowired
	private PushService pushService;

	@RequestMapping("/defer")
	@ResponseBody
	public DeferredResult<String> deferredCall(){
		return pushService.getAsyncUpdate();
	}
}
