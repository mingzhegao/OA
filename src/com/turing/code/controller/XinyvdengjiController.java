package com.turing.code.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turing.code.entity.CodeXinyvdengji;
import com.turing.code.service.IXinyvdengjiService;

@Controller
@RequestMapping("xydj")
@Scope("prototype")
public class XinyvdengjiController {
	
	@Autowired
	private IXinyvdengjiService xydjService;
	
	/**
	 * 跳转到查询页
	 * @param mp
	 * @return
	 */
	@RequestMapping("query")
	public String query(ModelMap mp){
		List<CodeXinyvdengji> list = xydjService.queryAll();
		mp.put("list", list);
		return "jsp/code/xydj/query_xydj";
	}
	
	/**
	 * 跳转到增加页
	 * @return
	 */
	@RequestMapping("addpage")
	public String addpage(){
		return "jsp/code/xydj/add_xydj";
	}
	
	/**
	 * 跳转到修改页
	 * @param mp
	 * @param id
	 * @return
	 */
	@RequestMapping("editpage")
	public String editpage(ModelMap mp,String id){
		CodeXinyvdengji xydj = xydjService.queryById(id);
		mp.put("xydj", xydj);
		return "jsp/code/xydj/edit_xydj";
	}
	
	/**
	 * 删除一条数据
	 * @param ids
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(String[] ids){
		xydjService.delete(ids);
		return "redirect:query.action";
	}
	
	/**
	 * 增加一条数据
	 * @param xydj
	 * @return
	 */
	@RequestMapping("save")
	public String save(CodeXinyvdengji xydj){
		xydjService.save(xydj);
		return "redirect:query.action";
	}
	
	/**
	 * 修改一条数据
	 * @param xydj
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(CodeXinyvdengji xydj){
		xydjService.edit(xydj);
		return "redirect:query.action";
	}
}
