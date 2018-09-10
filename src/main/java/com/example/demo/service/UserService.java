package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Admininfo;
import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.AdmininfoMapper;
import com.example.demo.mapper.UserinfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    AdmininfoMapper admininfoMapper;

    @Autowired
    UserinfoMapper userinfoMapper;

    public List<Admininfo> checkUser(String username, String password) {
        List<Admininfo> list = admininfoMapper.selectAdmin(username, password);
        System.out.println(JSON.toJSON(list));
        return admininfoMapper.selectAdmin(username, password);

    }

    public PageInfo<Userinfo> getAllUser(int pageNum, int pageSize) {
        // startPage(第几页, 多少条数据)
        PageHelper.startPage(pageNum, pageSize);
        // Mybatis查询方法
        List<Userinfo> list = userinfoMapper.selectAllUser();
        // 用PageInfo对结果进行包装
        PageInfo<Userinfo> pageInfo = new PageInfo(list);
        // System.out.println(JSON.toJSON(list));
        return pageInfo;
    }

    public Userinfo getUser(int userId) {
        return userinfoMapper.selectUser(userId);
    }
}
