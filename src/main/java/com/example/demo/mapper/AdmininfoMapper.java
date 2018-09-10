package com.example.demo.mapper;

import com.example.demo.entity.Admininfo;
import com.example.demo.entity.AdmininfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface AdmininfoMapper {
    int countByExample(AdmininfoExample example);

    int deleteByExample(AdmininfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admininfo record);

    int insertSelective(Admininfo record);

    List<Admininfo> selectByExample(AdmininfoExample example);

    Admininfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByExample(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByPrimaryKeySelective(Admininfo record);

    int updateByPrimaryKey(Admininfo record);
    //查找管理员用户是否存在
    List<Admininfo> selectAdmin(@Param("username") String username, @Param("password") String password);
}