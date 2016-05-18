package com.huluohu.learning.springmvc.controller.demo4;

import com.huluohu.learning.springmvc.vo.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huluohu on 2016/5/18.
 */
@Controller
@RequestMapping("/converter/")
public class ConverterController {
    @RequestMapping(value = "start" ,produces = {"application/x-huluohu"})
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj obj){
        return obj;
    }
}
