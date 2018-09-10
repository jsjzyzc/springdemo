package com.example.demo.mapper;

import com.example.demo.entity.Messageinfo;
import com.example.demo.entity.MessageinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MessageinfoMapper {
    int countByExample(MessageinfoExample example);

    int deleteByExample(MessageinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Messageinfo record);

    int insertSelective(Messageinfo record);

    List<Messageinfo> selectByExample(MessageinfoExample example);

    Messageinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Messageinfo record, @Param("example") MessageinfoExample example);

    int updateByExample(@Param("record") Messageinfo record, @Param("example") MessageinfoExample example);

    int updateByPrimaryKeySelective(Messageinfo record);

    int updateByPrimaryKey(Messageinfo record);
}