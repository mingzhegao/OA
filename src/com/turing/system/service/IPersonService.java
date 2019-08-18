package com.turing.system.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.turing.system.entity.SysDept;
import com.turing.system.entity.SysPerson;
import com.turing.system.entity.SysPost;
import com.turing.system.entity.SysUser;
import com.turing.system.page.PersonPage;

public interface IPersonService{

	SysPerson queryById(String id);

	void delete(String[] ids, HttpServletRequest request);

	void save(SysPerson person, HttpServletRequest request, CommonsMultipartFile picFile);

	void update(SysPerson person, HttpServletRequest request, CommonsMultipartFile picFile);

	List<SysDept> queryDept();

	List<SysPost> querySpByDeptId(String deptId);
	/**
	 * 查询未绑定的用户
	 * @return
	 */
	List<SysUser> queryUnconnectedUser();

	SysPerson queryAllInfoById(String ppId);
	/**
	 * 根据人员主键取消关联的用户
	 * @param ppId
	 */
	void updateUserIdToNull(String ppId);

	void saveUser(SysUser user);

	void queryForPage(PersonPage page);
	
	int queryForCount(PersonPage page);

}
