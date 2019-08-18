package com.turing.system.controller;


import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.turing.framework.select.SelectOptions;
import com.turing.system.entity.SysUser;
import com.turing.system.page.UserPage;
import com.turing.system.service.IUserService;

@Controller
@RequestMapping("user")
@Scope(value="prototype")
@SessionAttributes("userpage")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@ModelAttribute("userpage")
	public UserPage initPage(){
		return new UserPage();
	}
	
	@RequestMapping("saveNewPass")
	@ResponseBody
	public void saveNewPass(String newPass,HttpSession session){
		SysUser user = (SysUser) session.getAttribute("user");
		user.setUserPass(newPass);
		userService.update(user);
		session.invalidate();
	}
	
	@RequestMapping("query")
	public String query(@ModelAttribute("userpage")UserPage page,ModelMap mp) {
		userService.queryForPage(page);
		mp.put("page", page);
		return "jsp/system/user/query_user";
	}
	
	@RequestMapping("page")
	public String page(ModelMap mp,String id){
		if(null!=id){
			SysUser user = userService.queryById(id);
			mp.put("user", user);
		}
		return "jsp/system/user/page_user";
	}
	
	@RequestMapping("delete")
	public String delete(String[] ids){
		userService.delete(ids);
		return "redirect:query.action";
	}
	
	@RequestMapping("save")
	public String save(SysUser user){
		if("".equals(user.getUserId())){
			user.setUserId(UUID.randomUUID().toString());
			user.setUserState("A");
			userService.save(user);
		}else{
			userService.update(user);
		}
		return "redirect:query.action";
	}
	
	@RequestMapping("userRole")
	public String userRole(ModelMap mp,String id){
		SysUser user = userService.queryById(id);
		List<SelectOptions> roleList = userService.queryRoleByUser(id);
		mp.put("user", user);
		mp.put("roleList", roleList);
		return "jsp/system/user/user_role";
	}
	
	@RequestMapping("changeRole")
	public String changeRole(String userId,String roleIds){
		userService.changeRole(userId,roleIds);
		return "redirect:query.action";
	}
	
}
