package com.turing.system.mapper;

import java.util.List;

import com.turing.system.entity.SysRoleMenu;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(String rmid);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(String rmid);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

	List<SysRoleMenu> queryMenuByRoleId(String id);

	void deleteByRoleId(String roleId);
}