package com.turing.system.mapper;

import java.util.List;


import com.turing.system.entity.SysPost;
import com.turing.system.page.PosPage;

public interface SysPostMapper {
    int deleteByPrimaryKey(String spId);

    int insert(SysPost record);

    int insertSelective(SysPost record);

    SysPost selectByPrimaryKey(String spId);

    int updateByPrimaryKeySelective(SysPost record);

    int updateByPrimaryKey(SysPost record);

	List<SysPost> selective(SysPost sp);

	List<SysPost> queryForPage(PosPage page);

	int queryForCount(PosPage page);
}