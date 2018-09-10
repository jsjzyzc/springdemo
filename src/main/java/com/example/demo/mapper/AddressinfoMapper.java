package com.example.demo.mapper;

import com.example.demo.entity.Addressinfo;
import com.example.demo.entity.AddressinfoExample;
import java.util.List;

import com.example.demo.entity.Admininfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AddressinfoMapper {
    int countByExample(AddressinfoExample example);

    int deleteByExample(AddressinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Addressinfo record);

    int insertSelective(Addressinfo record);

    List<Addressinfo> selectByExample(AddressinfoExample example);

    Addressinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Addressinfo record, @Param("example") AddressinfoExample example);

    int updateByExample(@Param("record") Addressinfo record, @Param("example") AddressinfoExample example);

    int updateByPrimaryKeySelective(Addressinfo record);

    int updateByPrimaryKey(Addressinfo record);
}