package com.huluohu.learning.springmvc.core.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huluohu on 2016/5/17.
 * 控制器建言
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 全局异常处理
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView view = new ModelAndView("error");
        view.addObject("errorMsg",exception.getMessage());
        return view;
    }

    /**
     * 全局返回值中加入的响应
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }


    /**
     * 定制WebDataBinder
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //忽略参数id
        binder.setDisallowedFields("id");
    }
}
