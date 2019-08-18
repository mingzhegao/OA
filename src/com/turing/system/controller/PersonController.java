package com.turing.system.controller;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysPerson;
import com.turing.system.entity.SysPost;
import com.turing.system.entity.SysUser;
import com.turing.system.page.PersonPage;
import com.turing.system.service.IPersonService;

@Controller
@RequestMapping("person")
@Scope("prototype")
@SessionAttributes("personpage")
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@ModelAttribute("personpage")
	public PersonPage initPage(){
		return new PersonPage();
	}
	
	@RequestMapping("query")
	public String query(@ModelAttribute("personpage")PersonPage page,ModelMap mp){
		//查询分页数据
		personService.queryForPage(page);
		//往页面传值
		mp.put("page", page);
		List<SysDept> deptList = personService.queryDept();
		mp.put("deptList", deptList);
		return "jsp/system/person/query_person";
	}
	
	@RequestMapping("page")
	public String page(ModelMap mp,String id){
		if(null!=id){
			SysPerson person = personService.queryById(id);
			mp.put("person", person);
		}
		List<SysDept> deptList = personService.queryDept();
		mp.put("deptList", deptList);
		return "jsp/system/person/page_person";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids,HttpServletRequest request){
		personService.delete(ids,request);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(SysPerson person,@RequestParam("pic") CommonsMultipartFile picFile,HttpServletRequest request,String birth,String inTime) throws ParseException{	
		
		if("".equals(person.getPpId())){
			personService.save(person,request,picFile);
		}else{
			personService.update(person,request,picFile);
		}
		return "redirect:query.action";
	}
	
	@RequestMapping("querySp")
	@ResponseBody
	public String querySp(String deptId){
		String opts = "";
		List<SysPost> spList = personService.querySpByDeptId(deptId);
		for (SysPost sysPost : spList) {
			opts+="<option value='"+sysPost.getSpId()+"'>"+sysPost.getSpName()+"</option>";
		}
		return opts;
	}
	
	@RequestMapping("userPerson")
	public String userPerson(ModelMap mp,String ppId){
		SysPerson person = personService.queryAllInfoById(ppId);
		List<SysUser> userList = personService.queryUnconnectedUser();
		mp.put("person", person);
		mp.put("userList", userList);
		return "jsp/system/person/user_person";
	}
	
	@RequestMapping("disconnect")
	public String disconnect(String ppId){
		personService.updateUserIdToNull(ppId);
		return "redirect:query.action";
	}
	
	@RequestMapping("saveUser")
	public String saveUser(String ppId,String userId){
		SysPerson pp = personService.queryById(ppId);
		pp.setUserId(userId);
		personService.update(pp,null,null);
		return "redirect:query.action";
	}
	
	@RequestMapping("saveNewUser")
	public String saveNewUser(SysUser user,String ppId){
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		user.setUserState("A");
		personService.saveUser(user);
		SysPerson pp = personService.queryById(ppId);
		pp.setUserId(userId);
		personService.update(pp,null,null);
		return "redirect:query.action";
	}
}
