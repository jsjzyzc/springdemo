package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.ImgJsonBean;
import com.example.demo.entity.Productinfo;
import com.example.demo.mapper.ProductinfoMapper;
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
public class IndexProducinfo {
    /**
     * 市场信息管理
     */
    @Autowired
    ProductinfoMapper productinfoMapper;

    @RequestMapping("productinfo/{pageNum}/{type}")
    public ModelAndView productinfoByType(@PathVariable("pageNum") int pageNum, @PathVariable("type") String type, ModelAndView modelAndView) {
        List<Productinfo> list;
        // Mybatis查询方法
        // startPage(第几页, 多少条数据)
        PageHelper.startPage(pageNum, 8);
        if (type == null || type.equals("") || type.equals("all")) {
            list = productinfoMapper.selectAllProduct();
        } else {
            // startPage(第几页, 多少条数据)
            list = productinfoMapper.selectProductByType(type);
        }
        PageHelper.clearPage();
        // 用PageInfo对结果进行包装
        PageInfo<Productinfo> pageInfo = new PageInfo(list);
        //System.out.println(JSON.toJSONString(list));
        //图片json处理
        List<List<ImgJsonBean>> ImgList = new ArrayList<>();
        for (Productinfo product : list) {
            JSONArray jsonArray = JSONArray.parseArray(product.getImg());
            List<ImgJsonBean> imgjsonlist = (List) jsonArray;
            ImgList.add(imgjsonlist);
        }
        // System.out.println(ImgList);
        modelAndView.addObject("imglist", ImgList);
        modelAndView.addObject("nowtype", type);
        modelAndView.addObject("types", productinfoMapper.selectProductType());
        modelAndView.addObject("productlist", list);
        modelAndView.addObject("productpage", pageInfo);
        modelAndView.setViewName("productinfo");
        return modelAndView;
    }

    @RequestMapping("deleteproduct/{productId}")
    public ModelAndView deleteproducti(@PathVariable("productId") int productId, ModelAndView modelAndView) {
        productinfoMapper.deleteByPrimaryKey(productId);
        modelAndView.setViewName("redirect:/index/productinfo/1/all");
        return modelAndView;
    }

    @RequestMapping("editproduct/{productId}")
    public ModelAndView editproduct(@PathVariable("productId") int productId, ModelAndView modelAndView) {
        modelAndView.addObject("product", productinfoMapper.selectProductById(productId));
        modelAndView.setViewName("productinfoEdit");
        return modelAndView;
    }

    @RequestMapping("editproduct")
    public ModelAndView UpdataEditproduct(@Valid Productinfo Productinfo, BindingResult bindingResult, ModelAndView modelAndView) {

        //System.out.println(JSON.toJSONString(Productinfo));
        productinfoMapper.updateByPrimaryKeySelective(Productinfo);
        modelAndView.setViewName("redirect:/index/editproduct/" + Productinfo.getId());
        return modelAndView;
    }
}
