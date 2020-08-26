package com.cozarb.dao.accountmanagement;

import com.cozarb.bo.accountmanagement.SystemUserBo;
import com.cozarb.bo.accountmanagement.SystemUserDetailsBo;

public interface UserManagementDao {
	int saveCustomer(SystemUserBo systemUser);

	int getUserRoleIdByRoleCode(String roleCode);

	int countSystemUserByEmailAddress(String emailAddress);

	SystemUserBo getSystemUser(int systemUserId);

	void updateSystemUser(SystemUserBo systemUser);
	
	SystemUserDetailsBo getSystemUserWithRoleByEmailAddress(String emailAddress);
}
