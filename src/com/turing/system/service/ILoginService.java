package com.turing.system.service;

import java.util.List;

import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysMenu;
import com.turing.system.entity.SysPerson;
import com.turing.system.entity.SysUser;

public interface ILoginService {

	/**
	 * 查询所有一级菜单
	 * @return
	 */
	List<SysMenu> queryAllMenuByTop();
	/**
	 * 查询第一个一级菜单下的二级菜单
	 * @return
	 */
	List<SysMenu> queryAllMenuByOne();

	List<SysMenu> queryMenuByTop(SysUser user);

	List<SysMenu> queryMenuByOne(SysUser user);

	List<SysUser> queryUserWithPerson(SysUser user);

	SysPerson queryPersonById(String sysPersonId);

	SysDept queryDeptById(String deptId);
	
	SysMenu queryMenuById(String pid);
	
	List queryMenuByOther(SysMenu temMenu);

}
