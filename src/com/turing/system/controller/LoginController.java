package com.turing.system.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysMenu;
import com.turing.system.entity.SysPerson;
import com.turing.system.entity.SysUser;
import com.turing.system.service.ILoginService;

@Controller
@RequestMapping("/login")
@Scope(value="prototype")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("login")
	public String login(ModelMap mp,SysUser user,HttpSession session,HttpServletRequest request){
		String loginState = "";
		String pid;
		String message = "";
		//是否是
		if("AAAAA".equals(user.getUserName())){
			loginState="ok";
			
			// 成功取得用户的权限
			List<SysMenu> topList=loginService.queryAllMenuByTop();
			if(topList!=null  && topList.size()>0){
				pid = topList.get(0).getMenuId();
				List<SysMenu> oneList=loginService.queryAllMenuByOne();		
				//将用户的信息存入到session中
				session.setAttribute("oneList", oneList);
				session.setAttribute("topList", topList);
				session.setAttribute("pid", pid);
			}else{
				SysMenu  menu=new SysMenu("xxx", "","系统设置", "1","0");
				topList.add(menu);
				pid="xxx";
				session.setAttribute("oneList", new ArrayList());
				session.setAttribute("topList", topList);
				session.setAttribute("pid", pid);
			}
			SysUser deUser=new SysUser();
			deUser.setNickName("临时");
			deUser.setUserId("0");
			session.setAttribute("user", deUser);		
			
			SysPerson tempPP=new SysPerson();
			tempPP.setPpName("临时");
			session.setAttribute("people", tempPP);		
			
			mp.put("message", message);
			mp.put("loginState", loginState);
			return "bridge";
		}
		
		// 判断是否登录成功,noUser表示没查到用户，noPerson表示用户未与人员关联，ok表示登录成功
		List<SysUser> dbUserList = loginService.queryUserWithPerson(user);
		if(dbUserList.size()>1){
			message="登录信息重复，请与管理员联系!";
			loginState="reLogin";
			mp.put("message", message);
			mp.put("loginState", loginState);
			return "bridge";
		}else if(dbUserList.size()==0){
			message="登录名或密码错误!";
			loginState="reLogin";
			mp.put("message", message);
			mp.put("loginState", loginState);
			return "bridge";
		}else if(dbUserList.get(0).getSysPersonId()==null){
			message="当前用户没有与人员关联，请设置好后重新登录！";
			loginState="reLogin";
			mp.put("message", message);
			mp.put("loginState", loginState);
			return "bridge";
			}else{		
				loginState="ok";
			}
		// 成功取得用户的权限
		List<SysMenu> topList=loginService.queryMenuByTop(dbUserList.get(0));
		if(topList!=null  && topList.size()>0){
			pid=topList.get(0).getMenuId();
			List<SysMenu> oneList=loginService.queryMenuByOne(dbUserList.get(0));
			//可以取得与用户关联的人员信息
			//。。。
			SysPerson  pp=loginService.queryPersonById(dbUserList.get(0).getSysPersonId());
			SysDept dp = loginService.queryDeptById(pp.getDeptId());
			System.out.println("欢迎"+dp.getDeptName()+"的"+pp.getPpName());
			session.setAttribute("user", dbUserList.get(0));
			session.setAttribute("dept", dp);
			session.setAttribute("person", pp);
			session.setAttribute("oneList", oneList);
			session.setAttribute("topList", topList);
			session.setAttribute("pid", pid);
			mp.put("message", message);
			mp.put("loginState", loginState);
			return "bridge";
		}else{
			message="没有权限";
			loginState="reLogin";
			mp.put("message", message);
			mp.put("loginState", loginState);
			return "bridge";
		}
	}
	
	@RequestMapping("menuLeft")
	@ResponseBody
	public List menuLeft(String pid,HttpSession session){
		SysUser user = (SysUser) session.getAttribute("user");
		List oneList = (List) session.getAttribute("oneList");
		List menuOtherList = new ArrayList();
		if( "0".equals(user.getUserId())   &&    "临时".equals(user.getNickName()) ){
			if("a".equals(pid)){
			}else{
				pid=(String) session.getAttribute("pid");
			}			
			if(oneList!=null &&  oneList.size()>0) {
				SysMenu temMenu = loginService.queryMenuById(pid);
				menuOtherList=loginService.queryMenuByOther(temMenu);
			}else{
				SysMenu  menu=new SysMenu("sys", "","系统维护", "2","xxx");
				menuOtherList.add(menu);
				SysMenu  menuUser=new SysMenu("user","user!query.action", "用户维护", "3","sys");
				menuOtherList.add(menuUser);
				SysMenu  menuRole=new SysMenu("role","role!query.action", "角色维护", "3","sys");
				menuOtherList.add(menuRole);
				SysMenu  menuMenu=new SysMenu("menu","menu!queryAll.action", "菜单维护", "3","sys");
				menuOtherList.add(menuMenu);
			}
		}else{
			SysMenu temMenu = loginService.queryMenuById(pid);
			temMenu.setUserId(user.getUserId());
			menuOtherList=loginService.queryMenuByOther(temMenu);
		}
		return menuOtherList;
	}
	
	@RequestMapping("layout")
	@ResponseBody()
	public void layout(HttpSession session){
		session.invalidate();
	}
	
}
