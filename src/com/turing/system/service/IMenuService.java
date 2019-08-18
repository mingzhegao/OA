package com.turing.system.service;

import java.util.List;

import com.turing.system.entity.SysMenu;

public interface IMenuService {
	/**
	 * 查询所有一级菜单并将其子菜单放在menuList中
	 * @return
	 */
	List<SysMenu> queryAllWithList();

	SysMenu queryById(String id);

	void save(SysMenu menu);

	void update(SysMenu menu);

	void deleteById(String id);

}
