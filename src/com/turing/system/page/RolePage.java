package com.turing.system.page;

import org.apache.commons.lang.StringUtils;

import com.turing.framework.util.BasicPage;


public class RolePage extends BasicPage {


	private String roleName;
	
	public String getRoleName() {
		if(StringUtils.isBlank(roleName)){
			return null;
		}else{
			return roleName;
		}
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
