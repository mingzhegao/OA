package com.turing.system.page;

import org.apache.commons.lang.StringUtils;

import com.turing.framework.util.BasicPage;


public class UserPage extends BasicPage {


	private String userName;
	private String nickName;
	

	public String getUserName() {
		if(StringUtils.isBlank(userName)){
			return null;
		}else{
			return userName;
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		if(StringUtils.isBlank(nickName)){
			return null;
		}else{
			return nickName;
		}
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
