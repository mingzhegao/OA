package com.turing.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.turing.code.entity.GONGCHENGLEIXING;
import com.turing.code.entity.SHANGPINLEIXING;

public interface GONGCHENGLEIXINGMapper {
    int deleteByPrimaryKey(String cglId);

    int insert(GONGCHENGLEIXING record);

    int insertSelective(GONGCHENGLEIXING record);

    GONGCHENGLEIXING selectByPrimaryKey(String cglId);

    int updateByPrimaryKeySelective(GONGCHENGLEIXING record);

    int updateByPrimaryKey(GONGCHENGLEIXING record);
    @Select("select * from CODE_GONGCHENGLEIXING")
    @ResultMap("BaseResultMap")
    List<GONGCHENGLEIXING> queryAll();
}