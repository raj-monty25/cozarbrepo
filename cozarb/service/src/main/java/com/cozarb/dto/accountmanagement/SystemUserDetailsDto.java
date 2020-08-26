package com.cozarb.dto.accountmanagement;

public class SystemUserDetailsDto {
	protected SystemUserDto systemUser;
	protected UserRoleDto userRole;

	public SystemUserDetailsDto(SystemUserDto systemUser, UserRoleDto userRole) {
		this.systemUser = systemUser;
		this.userRole = userRole;
	}

	public SystemUserDto getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUserDto systemUser) {
		this.systemUser = systemUser;
	}

	public UserRoleDto getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleDto userRole) {
		this.userRole = userRole;
	}

}
