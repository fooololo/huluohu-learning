package com.huluohu.learning.spring.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huluohu on 2016/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
@ActiveProfiles({"pro"})
public class DemoBeanIntegrationTests {
    @Autowired
    private TestBean testBean;

    @Test
    public void proBeanShouldInject(){
        String expected = "from pro profile";
        String actual = testBean.getContent();
        System.out.println("actual:" + actual);
        Assert.assertEquals(expected,actual);
    }


}
