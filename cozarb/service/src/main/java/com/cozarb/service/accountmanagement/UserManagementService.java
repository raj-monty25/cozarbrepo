package com.cozarb.service.accountmanagement;

import com.cozarb.dto.accountmanagement.CustomerRegistrationDto;
import com.cozarb.dto.accountmanagement.SystemUserDetailsDto;

public interface UserManagementService {
	int registerCustomer(CustomerRegistrationDto customerRegistration);

	boolean isEmailAddressAvailable(String emailAddress);

	int verifyUserEmailAddress(int systemUserId, String emailVerificationCode);

	int verifyUserMobileNumber(int systemUserId, String mobileVerificationCode);

	SystemUserDetailsDto getSystemUserWithRoleByEmailAddress(String emailAddress);
}
