package com.cozarb.bo.accountmanagement;

public class SystemUserDetailsBo {
	private SystemUserBo systemUserBo;
	private UserRoleBo userRoleBo;

	public SystemUserDetailsBo(SystemUserBo systemUserBo, UserRoleBo userRoleBo) {
		this.systemUserBo = systemUserBo;
		this.userRoleBo = userRoleBo;
	}

	public SystemUserBo getSystemUserBo() {
		return systemUserBo;
	}

	public void setSystemUserBo(SystemUserBo systemUserBo) {
		this.systemUserBo = systemUserBo;
	}

	public UserRoleBo getUserRoleBo() {
		return userRoleBo;
	}

	public void setUserRoleBo(UserRoleBo userRoleBo) {
		this.userRoleBo = userRoleBo;
	}

}
