package com.turing.system.page;


import org.apache.commons.lang.StringUtils;

import com.turing.framework.util.BasicPage;

public class PosPage extends BasicPage{

	private String posName;
	private String deptId;

	public String getPosName() {
		if(StringUtils.isBlank(posName)){
			return null;
		}else{
			return posName;
		}
	}

	public void setPosName(String posName) {
		this.posName = posName;
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
