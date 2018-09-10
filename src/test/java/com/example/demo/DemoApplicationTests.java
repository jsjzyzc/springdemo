package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.ImgJsonBean;
import com.example.demo.entity.Productinfo;
import com.example.demo.mapper.ProductinfoMapper;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    ProductinfoMapper productinfoMapper;

    @Test
    public void pageUser() {
        System.out.println(JSON.toJSON(userService.getAllUser(1, 5)));
    }

    @Test
    public void JsonImg() {
        String jsonstr;
        Map<String, List<ImgJsonBean>> ImgMap = new HashMap<>();
        List<Productinfo> productinfos = productinfoMapper.selectAllProduct();
        for (Productinfo product : productinfos) {
            JSONArray jsonArray = JSONArray.parseArray(product.getImg());
            List<ImgJsonBean> imgjsonlist = (List) jsonArray;
            ImgMap.put(product.getId() + "", imgjsonlist);
        }
        System.out.println(ImgMap);
    }
}
