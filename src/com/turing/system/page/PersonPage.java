package com.turing.system.page;


import org.apache.commons.lang.StringUtils;

import com.turing.framework.util.BasicPage;

public class PersonPage extends BasicPage{
	
	private String ppName;
	private String deptId;

	public String getPpName() {
		if(StringUtils.isBlank(ppName)){
			return null;
		}else{
			return ppName;
		}
	}

	public void setPpName(String ppName) {
		this.ppName = ppName;
	}

	public String getDeptId() {
		if(StringUtils.isBlank(deptId)){
			return null;
		}else{
			return deptId;
		}
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
