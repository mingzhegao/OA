package com.turing.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.code.entity.SHANGPINLEIXING;
import com.turing.code.service.IShangPinLeiXingService;

@RequestMapping("/splx")
@Controller
public class SplxController {
	@Autowired
	private IShangPinLeiXingService splx;
	
	@RequestMapping("/query")
	public String querySplx(ModelMap map) {
		System.out.println("请求商品类型");
		List<SHANGPINLEIXING> list=splx.querySplx();
		for(SHANGPINLEIXING ss:list) {
			System.out.println(ss);
		}
		map.put("list", list);
		return "jsp/code/splx/query_splx";
	}
	@RequestMapping("/addpage")
	public String addpage() {
		
		return "splx/add_splx";
	}
	@RequestMapping("/save")
	public String save(SHANGPINLEIXING splxs) {
		splx.save(splxs);
		return "redirect:/query.action";
	}
	@RequestMapping("/editpage")
	public String editpage(String id,ModelMap map) {
		SHANGPINLEIXING splxx=splx.querySplxById(id);
		map.put("splx", splx);
		return "splx/edit_splx.jsp";
	}
	@RequestMapping("/edit")
	public String edit(SHANGPINLEIXING splxx,ModelMap map) {
		splx.edit(splxx);
		
		return "redirect:/query.action";
	}
	@RequestMapping("/delete")
	public String delete(String[] ids) {
		splx.delete(ids);
		
		return "redirect:/query.action";
	}
	
}
