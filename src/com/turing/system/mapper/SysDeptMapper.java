package com.turing.system.mapper;

import java.util.List;

import com.turing.system.entity.SysDept;

public interface SysDeptMapper {
    int deleteByPrimaryKey(String deptId);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(String deptId);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

	List<SysDept> selectAll();
	/**
	 * 查询一级部门菜单
	 * @return
	 */
	List<SysDept> queryAllDeptByTop();
	/**
	 * 查询子部门
	 * @param dept
	 * @return
	 */
	List<SysDept> queryDeptByOne(SysDept dept);
}