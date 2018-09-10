package com.example.demo.mapper;

import com.example.demo.entity.Productinfo;
import com.example.demo.entity.ProductinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductinfoMapper {
    int countByExample(ProductinfoExample example);

    int deleteByExample(ProductinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    List<Productinfo> selectByExampleWithBLOBs(ProductinfoExample example);

    List<Productinfo> selectByExample(ProductinfoExample example);

    Productinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Productinfo record, @Param("example") ProductinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Productinfo record, @Param("example") ProductinfoExample example);

    int updateByExample(@Param("record") Productinfo record, @Param("example") ProductinfoExample example);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKeyWithBLOBs(Productinfo record);

    int updateByPrimaryKey(Productinfo record);

    //查询所有产品结果集
    List<Productinfo> selectAllProduct();

    //查找有多少类别产品
    List<Productinfo> selectProductType();

    //按类别查找产品
    List<Productinfo> selectProductByType(@Param("producttype") String producttype);

    //根据ID查找单个租赁信息
    Productinfo selectProductById(int productId);
}