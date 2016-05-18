package com.huluohu.learning.springmvc.web;

import com.huluohu.learning.springmvc.service.demo2.DemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/18
 * Time           :   10:35
 * Description    :
 */
public class DemoTest extends WebTest {
	@Autowired
	DemoService demoService;

	@Test
	public void testPage() throws Exception {
		mockMvc.perform(get("/normal"))
				.andExpect(status().isOk())
				.andExpect(view().name("page"))
				.andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))
				.andExpect(model().attribute("msg",demoService.say()))
		;
	}

	@Test
	public void testRest() throws Exception {
		mockMvc.perform(get("/rest/json"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().string("{\"id\":12,\"name\":\"JSON\"}"));
	}
}
