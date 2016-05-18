package com.huluohu.learning.springmvc.web;

import com.huluohu.learning.springmvc.config.MvcConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/5/18
 * Time           :   10:26
 * Description    :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class WebTest {
	protected MockMvc mockMvc;
	@Autowired
	protected WebApplicationContext wac;
	@Autowired
	protected MockHttpSession session;
	@Autowired
	protected MockHttpServletRequest request;

	@Before
	public void  setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

}
