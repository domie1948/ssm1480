package com.yjkj.framework.rbac.bargain.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.custom.model.Custom;
import com.yjkj.framework.rbac.information.model.Information;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

public class Bargain extends BaseModel {
	
	private String custom_id;
	private String user_id;
	private String information_id;
	private Custom custom;
	private String searchName;
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	private Information information;
	private UserInfo userInfo;
	private String status;
	public String getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(String custom_id) {
		this.custom_id = custom_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getInformation_id() {
		return information_id;
	}
	public void setInformation_id(String information_id) {
		this.information_id = information_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	public Information getInformation() {
		return information;
	}
	public void setInformation(Information information) {
		this.information = information;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
