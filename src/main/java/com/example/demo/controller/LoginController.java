package com.example.demo.controller;

import com.example.demo.entity.Admininfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    HttpSession session;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("checkLogin")
    public ModelAndView checkLogin(String username, String password, ModelAndView modelAndView) {
        List<Admininfo> userlist;
        if (userService.checkUser(username, password).size() > 0) {
            userlist = userService.checkUser(username, password);
            session.setAttribute("nowUser", userlist.get(0));
            modelAndView.setViewName("redirect:index/toIndex");
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("logininfo", "登陆失败");
        }
        return modelAndView;
    }
}
