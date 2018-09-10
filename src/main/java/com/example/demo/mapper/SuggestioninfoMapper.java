package com.example.demo.mapper;

import com.example.demo.entity.Suggestioninfo;
import com.example.demo.entity.SuggestioninfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SuggestioninfoMapper {
    int countByExample(SuggestioninfoExample example);

    int deleteByExample(SuggestioninfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Suggestioninfo record);

    int insertSelective(Suggestioninfo record);

    List<Suggestioninfo> selectByExample(SuggestioninfoExample example);

    Suggestioninfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Suggestioninfo record, @Param("example") SuggestioninfoExample example);

    int updateByExample(@Param("record") Suggestioninfo record, @Param("example") SuggestioninfoExample example);

    int updateByPrimaryKeySelective(Suggestioninfo record);

    int updateByPrimaryKey(Suggestioninfo record);
}