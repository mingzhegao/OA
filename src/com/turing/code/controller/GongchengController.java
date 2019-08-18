package com.turing.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.code.entity.GONGCHENGLEIXING;
import com.turing.code.entity.SHANGPINLEIXING;
import com.turing.code.service.IGongchengleixingService;

@RequestMapping("/gclx")
@Controller
public class GongchengController {
	@Autowired
	private IGongchengleixingService gclx;
	
	@RequestMapping("/query")
	public String querySplx(ModelMap map) {
		System.out.println("请求gg类型");
		List<GONGCHENGLEIXING> list=gclx.querygclx();
		map.put("list", list);
		return "jsp/code/gclx/query_gclx";
	}
	@RequestMapping("/addpage")
	public String addpage() {
		
		return "jsp/code/gclx/add_gclx";
	}
	@RequestMapping("/save")
	public String save(GONGCHENGLEIXING gclxs) {
		gclx.save(gclxs);
		return "redirect:/gclx/query.action";
	}
	@RequestMapping("/editpage")
	public String editpage(String id,ModelMap map) {
		GONGCHENGLEIXING gclxx=gclx.querySplxById(id);
		map.put("gclx", gclxx);
		return "jsp/code/gclx/edit_gclx";
	}
	@RequestMapping("/edit")
	public String edit(GONGCHENGLEIXING gclxx,ModelMap map) {
		gclx.edit(gclxx);
		
		return "redirect:/gclx/query.action";
	}
	@RequestMapping("/delete")
	public String delete(String[] ids) {
		gclx.delete(ids);
		return "redirect:/gclx/query.action";
	}
	
}
