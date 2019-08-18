package com.turing.code.mapper;

import java.util.List;

import com.turing.code.entity.CodeXinyvdengji;

public interface CodeXinyvdengjiMapper {
    int deleteByPrimaryKey(String cxyId);

    int insert(CodeXinyvdengji record);

    int insertSelective(CodeXinyvdengji record);

    CodeXinyvdengji selectByPrimaryKey(String cxyId);

    int updateByPrimaryKeySelective(CodeXinyvdengji record);

    int updateByPrimaryKey(CodeXinyvdengji record);
    
	List<CodeXinyvdengji> queryAll();
}