package com.example.demo.mapper;

import com.example.demo.entity.Testdb;
import com.example.demo.entity.TestdbExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TestdbMapper {
    int countByExample(TestdbExample example);

    int deleteByExample(TestdbExample example);

    int insert(Testdb record);

    int insertSelective(Testdb record);

    List<Testdb> selectByExample(TestdbExample example);

    int updateByExampleSelective(@Param("record") Testdb record, @Param("example") TestdbExample example);

    int updateByExample(@Param("record") Testdb record, @Param("example") TestdbExample example);
}