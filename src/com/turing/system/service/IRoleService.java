package com.turing.system.service;

import java.util.List;

import com.turing.framework.select.SelectOptions;
import com.turing.system.entity.SysRole;
import com.turing.system.page.RolePage;

public interface IRoleService {

	SysRole queryById(String id);

	void delete(String[] ids);

	void save(SysRole role);

	void update(SysRole role);

	List<SelectOptions> queryRoleMenu(String id);

	void roleMenu(String roleId, String menuIds);

	void queryForPage(RolePage page);
	
	int queryForCount(RolePage page);

}
