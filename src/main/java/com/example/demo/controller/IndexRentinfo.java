package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.ImgJsonBean;
import com.example.demo.entity.Productinfo;
import com.example.demo.entity.Rentinfo;
import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.RentinfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexRentinfo {
    /**
     * 租赁信息管理
     */
    @Autowired
    RentinfoMapper rentinfoMapper;

    @RequestMapping("rentinfo/{pageNum}")
    public ModelAndView rentinfo(@PathVariable("pageNum") int pageNum, ModelAndView modelAndView) {

        // startPage(第几页, 多少条数据)
        PageHelper.startPage(pageNum, 8);
        // Mybatis查询方法
        List<Rentinfo> list = rentinfoMapper.selectAllRent();
        // 用PageInfo对结果进行包装
        PageInfo<Rentinfo> pageInfo = new PageInfo(list);
        // System.out.println(JSON.toJSON(list));
        //图片json处理
        List<List<ImgJsonBean>> ImgList = new ArrayList<>();
        for (Rentinfo product : list) {
            JSONArray jsonArray = JSONArray.parseArray(product.getImg());
            List<ImgJsonBean> imgjsonlist = (List) jsonArray;
            ImgList.add(imgjsonlist);
        }
        // System.out.println(ImgList);
        modelAndView.addObject("imglist", ImgList);
        modelAndView.addObject("rentinfolist", list);
        modelAndView.addObject("rentpage", pageInfo);
        modelAndView.setViewName("rentinfo");
        return modelAndView;
    }

    @RequestMapping("deleterent/{rentId}")
    public ModelAndView deleteuser(@PathVariable("rentId") int userId, ModelAndView modelAndView) {
        rentinfoMapper.deleteByPrimaryKey(userId);
        modelAndView.setViewName("redirect:/index/rentinfo/1");
        return modelAndView;
    }

    @RequestMapping("editrent/{rentId}")
    public ModelAndView editrent(@PathVariable("rentId") int rentId, ModelAndView modelAndView) {
        modelAndView.addObject("rent", rentinfoMapper.selectRentById(rentId));
        modelAndView.setViewName("rentinfoEdit");
        return modelAndView;
    }

    @RequestMapping("editrent")
    public ModelAndView UpdataEditrent(@Valid Rentinfo rentinfo, BindingResult bindingResult, ModelAndView modelAndView) {

        System.out.println(JSON.toJSONString(rentinfo));
        rentinfoMapper.updateByPrimaryKeySelective(rentinfo);
        modelAndView.setViewName("redirect:/index/editrent/" + rentinfo.getId());
        return modelAndView;
    }
}
