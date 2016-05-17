package com.huluohu.learning.springmvc.controller.demo2;

import com.huluohu.learning.springmvc.vo.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huluohu on 2016/5/18.
 */
@Controller
@RequestMapping("/advice/")
public class AdviceController {

    @RequestMapping("something")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        throw new IllegalArgumentException("非法参数:"+msg);
    }
}
