package com.example.demo.mapper;

import com.example.demo.entity.Collectinfo;
import com.example.demo.entity.CollectinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CollectinfoMapper {
    int countByExample(CollectinfoExample example);

    int deleteByExample(CollectinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collectinfo record);

    int insertSelective(Collectinfo record);

    List<Collectinfo> selectByExampleWithBLOBs(CollectinfoExample example);

    List<Collectinfo> selectByExample(CollectinfoExample example);

    Collectinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collectinfo record, @Param("example") CollectinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Collectinfo record, @Param("example") CollectinfoExample example);

    int updateByExample(@Param("record") Collectinfo record, @Param("example") CollectinfoExample example);

    int updateByPrimaryKeySelective(Collectinfo record);

    int updateByPrimaryKeyWithBLOBs(Collectinfo record);

    int updateByPrimaryKey(Collectinfo record);
}