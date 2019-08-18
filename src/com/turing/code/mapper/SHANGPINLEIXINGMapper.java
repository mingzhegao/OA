package com.turing.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.turing.code.entity.SHANGPINLEIXING;

public interface SHANGPINLEIXINGMapper {
    int deleteByPrimaryKey(String cslId);

    int insert(SHANGPINLEIXING record);

    int insertSelective(SHANGPINLEIXING record);

    SHANGPINLEIXING selectByPrimaryKey(String cslId);

    int updateByPrimaryKeySelective(SHANGPINLEIXING record);

    int updateByPrimaryKey(SHANGPINLEIXING record);
    @Select("select * from CODE_SHANGPINLEIXING")
    @ResultMap("BaseResultMap")
	List<SHANGPINLEIXING> queryAll();
}