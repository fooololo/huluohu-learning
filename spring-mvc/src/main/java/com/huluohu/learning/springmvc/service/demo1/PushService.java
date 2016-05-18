package com.huluohu.learning.springmvc.service.demo1;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/18
 * Time           :   9:57
 * Description    :  推送
 */
@Service
public class PushService {
	private DeferredResult<String> deferredResult;

	@Scheduled(fixedDelay = 5000)
	public void refresh(){
		if(deferredResult != null){
			deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
		}
	}

	public DeferredResult<String> getAsyncUpdate(){
		deferredResult = new DeferredResult<>();
		return deferredResult;
	}
}
