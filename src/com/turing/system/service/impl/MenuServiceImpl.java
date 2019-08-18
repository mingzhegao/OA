package com.turing.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.system.entity.SysMenu;
import com.turing.system.mapper.SysMenuMapper;
import com.turing.system.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService{

	@Autowired
	private SysMenuMapper menuMapper;
	
	@Override
	public List<SysMenu> queryAllWithList() {
		List<SysMenu> topMenuList = menuMapper.queryAllMenuByTop();
		List<SysMenu> rvList = new ArrayList<SysMenu>();
		for (SysMenu sysMenu : topMenuList) {
			SysMenu rv = this.recursiveMenuByTopMenu(sysMenu);
			rvList.add(rv);
		}
		return rvList;
	}
	
	private SysMenu recursiveMenuByTopMenu(SysMenu menu) {
		
		List<SysMenu> childMenus = menuMapper.queryMenuByOne(menu);
		for (SysMenu sysMenu : childMenus) {
			SysMenu m = recursiveMenuByTopMenu(sysMenu);
			menu.getMenuList().add(m);
		}
		return menu;
	}

	@Override
	public SysMenu queryById(String id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(SysMenu menu) {
		menuMapper.insertSelective(menu);
	}

	@Override
	public void update(SysMenu menu) {
		menuMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public void deleteById(String id) {
		menuMapper.deleteByPrimaryKey(id);
	}

}
