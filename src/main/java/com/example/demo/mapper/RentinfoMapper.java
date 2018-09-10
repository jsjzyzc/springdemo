package com.example.demo.mapper;

import com.example.demo.entity.Rentinfo;
import com.example.demo.entity.RentinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RentinfoMapper {
    int countByExample(RentinfoExample example);

    int deleteByExample(RentinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rentinfo record);

    int insertSelective(Rentinfo record);

    List<Rentinfo> selectByExampleWithBLOBs(RentinfoExample example);

    List<Rentinfo> selectByExample(RentinfoExample example);

    Rentinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rentinfo record, @Param("example") RentinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Rentinfo record, @Param("example") RentinfoExample example);

    int updateByExample(@Param("record") Rentinfo record, @Param("example") RentinfoExample example);

    int updateByPrimaryKeySelective(Rentinfo record);

    int updateByPrimaryKeyWithBLOBs(Rentinfo record);

    int updateByPrimaryKey(Rentinfo record);

    //查找租赁信息所有结果集
    List<Rentinfo> selectAllRent();
    //根据ID查找单个租赁信息
    Rentinfo selectRentById(int rentId);
}