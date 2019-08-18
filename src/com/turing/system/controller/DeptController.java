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

import com.turing.system.entity.SysDept;
import com.turing.system.service.IDeptService;

@Controller
@RequestMapping("dept")
@Scope("prototype")
public class DeptController {
	
	@Autowired
	private IDeptService deptService;
	
	@RequestMapping("query")
	public String query(ModelMap mp){
		List<SysDept> topList =  deptService.queryAllWithList();
		mp.put("topList", topList);
		return "/jsp/system/dept/query_dept";
	}
	
	@RequestMapping("addpage")
	@ResponseBody
	public SysDept addpage(String id){
		SysDept parDept = deptService.queryById(id);
		return parDept;
	}
	
	@RequestMapping("editpage")
	@ResponseBody
	public List editpage(String id){
		List rvList = new ArrayList();
		SysDept dept = deptService.queryById(id);
		SysDept parDept = deptService.queryById(dept.getDeptPar());
		rvList.add(dept);
		rvList.add(parDept);
		return rvList;
	}
	
	@RequestMapping("save")
	public String save(SysDept dept){
		if("".equals(dept.getDeptId())){
			dept.setDeptId(UUID.randomUUID().toString());
			dept.setDeptState("A");
			deptService.save(dept);
		}else{
			deptService.update(dept);
		}
		return "redirect:query.action";
	}
	
	@RequestMapping("delete")
	public String delete(String id){
		deptService.deleteById(id);
		return "redirect:query.action";
	}
}
