package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index")
public class IndexAllController {
    /**
     * 来到主页并进行渲染
     */
    @RequestMapping("toIndex")
    public ModelAndView toIndex(ModelAndView modelAndView) {

        modelAndView.setViewName("Index");
        return modelAndView;
    }





}
