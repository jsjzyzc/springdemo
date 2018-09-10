package com.example.demo.mapper;

import com.example.demo.entity.Cardinfo;
import com.example.demo.entity.CardinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CardinfoMapper {
    int countByExample(CardinfoExample example);

    int deleteByExample(CardinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cardinfo record);

    int insertSelective(Cardinfo record);

    List<Cardinfo> selectByExampleWithBLOBs(CardinfoExample example);

    List<Cardinfo> selectByExample(CardinfoExample example);

    Cardinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cardinfo record, @Param("example") CardinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Cardinfo record, @Param("example") CardinfoExample example);

    int updateByExample(@Param("record") Cardinfo record, @Param("example") CardinfoExample example);

    int updateByPrimaryKeySelective(Cardinfo record);

    int updateByPrimaryKeyWithBLOBs(Cardinfo record);

    int updateByPrimaryKey(Cardinfo record);
}