package com.example.demo.controller;

import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.UserinfoMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("index")
public class IndexUserinfo {
    /**
     * 用户信息管理
     */

    @Autowired
    UserService userService;
    @Autowired
    UserinfoMapper userinfoMapper;

    @RequestMapping("userinfo/{pageNum}")
    public ModelAndView userinfo(@PathVariable("pageNum") int pageNum, ModelAndView modelAndView) {
        PageInfo<Userinfo> pageInfo = userService.getAllUser(pageNum, 8);
        List<Userinfo> userinfoes = pageInfo.getList();
        modelAndView.addObject("UserPage", pageInfo);
        modelAndView.addObject("Users", userinfoes);
        modelAndView.setViewName("userinfo");
        return modelAndView;
    }

    @RequestMapping("edituser/{userId}")
    public ModelAndView edituser(@PathVariable("userId") int userId, ModelAndView modelAndView) {
        modelAndView.addObject("user", userService.getUser(userId));
        modelAndView.setViewName("userinfoEdit");
        return modelAndView;
    }

    @RequestMapping("edituser")
    public ModelAndView edituser(Userinfo userinfo, ModelAndView modelAndView) {
        userinfoMapper.updateByPrimaryKeySelective(userinfo);
        return modelAndView;
    }

    @RequestMapping("deleteuser/{userId}")
    public ModelAndView deleteuser(@PathVariable("userId") int userId, ModelAndView modelAndView) {
        userinfoMapper.deleteByPrimaryKey(userId);
        modelAndView.setViewName("redirect:/index/userinfo/1");
        return modelAndView;
    }
}
