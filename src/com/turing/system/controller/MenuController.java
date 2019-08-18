package com.turing.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turing.system.entity.SysMenu;
import com.turing.system.service.IMenuService;

@Controller
@RequestMapping("/menu")
@Scope(value="prototype")
public class MenuController {
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("main")
	public String main(){
		return "frame/main";
	}
	
	@RequestMapping("query")
	public String query(ModelMap mp){
		List<SysMenu> topList =  menuService.queryAllWithList();
		mp.put("topList", topList);
		return "/jsp/system/menu/query_menu";
	}
	
	@RequestMapping("addpage")
	@ResponseBody
	public SysMenu addpage(String id){
		SysMenu parMenu = menuService.queryById(id);
		return parMenu;
	}
	
	@RequestMapping("editpage")
	@ResponseBody
	public List editpage(String id){
		List rvList = new ArrayList();
		SysMenu menu = menuService.queryById(id);
		SysMenu parMenu = menuService.queryById(menu.getMenuPare());
		rvList.add(menu);
		rvList.add(parMenu);
		return rvList;
	}
	
	@RequestMapping("save")
	public String save(SysMenu menu){
		if("".equals(menu.getMenuId())){
			menu.setMenuId(UUID.randomUUID().toString());
			menu.setMenuState("A");
			menuService.save(menu);
		}else{
			menuService.update(menu);
		}
		return "redirect:query.action";
	}
	
	@RequestMapping("delete")
	public String delete(String id){
		menuService.deleteById(id);
		return "redirect:query.action";
	}
}
