package com.cozarb.service.accountmanagement;

import static com.cozarb.service.constants.CozarbServiceConstants.EMAIL_TEMPLATE_VERIFY_EMAIL;
import static com.cozarb.service.constants.CozarbServiceConstants.GLOBAL_SYSTEM_USER;
import static com.cozarb.service.constants.CozarbServiceConstants.REGISTRATION_VERIFY_STATUS_ALL;
import static com.cozarb.service.constants.CozarbServiceConstants.REGISTRATION_VERIFY_STATUS_EMAIL_ONLY_VERIFIED;
import static com.cozarb.service.constants.CozarbServiceConstants.REGISTRATION_VERIFY_STATUS_MOBILE_ONLY_VERIFIED;
import static com.cozarb.service.constants.CozarbServiceConstants.ROLE_CUSTOMER;
import static com.cozarb.service.constants.CozarbServiceConstants.STATUS_SYSTEM_USER_ACTIVATED;
import static com.cozarb.service.constants.CozarbServiceConstants.STATUS_SYSTEM_USER_REGISTERED;
import static com.cozarb.service.constants.CozarbServiceConstants.TEXT_TEMPLATE_VERIFY_MOBILE_NUMBER;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cozarb.bo.accountmanagement.SystemUserBo;
import com.cozarb.bo.accountmanagement.SystemUserDetailsBo;
import com.cozarb.dao.accountmanagement.UserManagementDao;
import com.cozarb.dto.accountmanagement.CustomerRegistrationDto;
import com.cozarb.dto.accountmanagement.SystemUserDetailsDto;
import com.cozarb.dto.accountmanagement.SystemUserDto;
import com.cozarb.dto.accountmanagement.UserRoleDto;
import com.cozarb.service.constants.CozarbServiceConstants;
import com.cozarb.service.exception.AccountAlreadyActivatedException;
import com.cozarb.service.exception.EmailAlreadyVerifiedException;
import com.cozarb.service.exception.MobileAlreadyVerifiedException;
import com.cozarb.service.exception.UserAccountNotFoundException;
import com.cozarb.service.exception.VerificationCodeMisMatchException;
import com.cozarb.service.logging.CozarbLogger;
import com.cozarb.service.notification.bean.MultimediaNotification;
import com.cozarb.service.notification.bean.Notification;
import com.cozarb.service.notification.bean.builder.MultimediaNotificationBuilder;
import com.cozarb.service.notification.bean.builder.NotificationBuilder;
import com.cozarb.service.notification.facade.NotificationFacade;
import com.cozarb.service.resource.reader.ClassPathFileResourceReader;
import com.cozarb.service.util.RandomCodeGenerator;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	private static final CozarbLogger cozarbLogger = CozarbLogger.getLogger(UserManagementServiceImpl.class);
	@Value("${site.auto.email}")
	private String noReplyEmailAddress;

	@Value("${site.customer.host}")
	private String host;

	@Value("${messaging.text.provider.sender}")
	private String textMessageSender;

	@Autowired
	private UserManagementDao userManagementDao;

	@Autowired
	private ClassPathFileResourceReader resourceReader;

	@Autowired
	@Qualifier("mailNotificationFacade")
	private NotificationFacade mailNotificationFacade;

	@Autowired
	@Qualifier("textLocalNotificationFacade")
	private NotificationFacade textNotificationFacade;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional(readOnly = false)
	public int registerCustomer(CustomerRegistrationDto customerRegistration) {
		int systemUserId = 0;
		int customerUserRoleId = 0;
		SystemUserBo systemUser = null;
		String emailVerificationCode = null;
		Notification textNotification = null;
		String mobileNumberVerificationCode = null;
		MultimediaNotificationBuilder builder = null;
		NotificationBuilder textNotificationBuilder = null;
		MultimediaNotification multimediaNotification = null;

		customerUserRoleId = userManagementDao.getUserRoleIdByRoleCode(ROLE_CUSTOMER);
		cozarbLogger.debug("retreived roleId : {} for the roleCode : {}", customerUserRoleId, ROLE_CUSTOMER);

		systemUser = new SystemUserBo();
		systemUser.setEmailAddress(customerRegistration.getEmailAddress());
		systemUser.setMobileNumber(customerRegistration.getMobileNumber());
		systemUser.setPassword(passwordEncoder.encode(customerRegistration.getPassword()));
		systemUser.setUserRoleId(customerUserRoleId);

		emailVerificationCode = RandomCodeGenerator.generateRandomAlhpaNumericWithSpecialCharsToken(12);
		mobileNumberVerificationCode = RandomCodeGenerator.generateRandomNumericToken(6);
		cozarbLogger.debug("emailVerificationCode : {} got generated", emailVerificationCode);
		cozarbLogger.debug("mobileVerificationCode : {} got generated", mobileNumberVerificationCode);

		systemUser.setEmailVerificationCode(emailVerificationCode);
		systemUser.setMobileNumberVerificationCode(mobileNumberVerificationCode);
		systemUser.setEmailAddressVerified(0);
		systemUser.setMobileNumberVerified(0);
		systemUser.setAccountStatus(STATUS_SYSTEM_USER_REGISTERED);

		systemUser.setCreatedBy(GLOBAL_SYSTEM_USER);
		systemUser.setCreatedDate(new Date());
		systemUser.setLastModifiedBy(GLOBAL_SYSTEM_USER);
		systemUser.setLastModifiedDate(new Date());

		systemUserId = userManagementDao.saveCustomer(systemUser);
		cozarbLogger.debug("returning customerId : {}", systemUserId);

		builder = new MultimediaNotificationBuilder(noReplyEmailAddress, EMAIL_TEMPLATE_VERIFY_EMAIL,
				customerRegistration.getEmailAddress()).subject("Email Verification");
		builder.attribute("host", host).attribute("userId", systemUserId).attribute("emailVerificationCode",
				emailVerificationCode);
		builder.addInlineAttachment("logo", resourceReader.getResource("static/images/logo.png"), "logo", "img/png")
				.addInlineAttachment("email_icon", resourceReader.getResource("static/images/email_icon.png"),
						"email_icon", "img/png")
				.addInlineAttachment("verify_email_banner",
						resourceReader.getResource("static/images/verify_email.png"), "verify_email_banner", "img/png");
		multimediaNotification = (MultimediaNotification) builder.build();
		mailNotificationFacade.notify(multimediaNotification);
		cozarbLogger.debug("sent verify email to emailAddress :{} " + customerRegistration.getEmailAddress());

		textNotificationBuilder = new NotificationBuilder(textMessageSender, TEXT_TEMPLATE_VERIFY_MOBILE_NUMBER,
				customerRegistration.getMobileNumber());
		textNotificationBuilder.attribute("otp", mobileNumberVerificationCode);

		textNotification = textNotificationBuilder.build();
		textNotificationFacade.notify(textNotification);
		cozarbLogger.debug("send text message to mobile Number {}" + customerRegistration.getMobileNumber());

		return systemUserId;
	}

	@Override
	public boolean isEmailAddressAvailable(String emailAddress) {
		int count = 0;

		count = userManagementDao.countSystemUserByEmailAddress(emailAddress);
		cozarbLogger.debug("found {} users for emailAddress {}", count, emailAddress);

		return count > 0 ? false : true;
	}

	@Override
	public int verifyUserEmailAddress(int systemUserId, String emailVerificationCode) {
		SystemUserBo systemUserBo = null;
		int verificationStatus = REGISTRATION_VERIFY_STATUS_ALL;

		systemUserBo = userManagementDao.getSystemUser(systemUserId);
		if (systemUserBo == null) {
			cozarbLogger.info("cannot find systemUser with id {} for verifying the email verification code {}",
					systemUserId, emailVerificationCode);
			throw new UserAccountNotFoundException("cannot find systemUser with id " + systemUserId);
		}

		if (systemUserBo.getAccountStatus().equals(STATUS_SYSTEM_USER_ACTIVATED)) {
			cozarbLogger.debug("systemUserId {} account has already active", systemUserId);
			throw new AccountAlreadyActivatedException("SystemUser already activated");
		} else if (systemUserBo.getEmailAddressVerified() == 1) {
			cozarbLogger.debug("email address already verified for system user {} ", systemUserId);
			throw new EmailAlreadyVerifiedException("User account email address already verified");
		}

		if (emailVerificationCode.equals(systemUserBo.getEmailVerificationCode()) == false) {
			cozarbLogger.info("email verification code mis-match for system user id {}", systemUserId);
			throw new VerificationCodeMisMatchException("email verification code not matched");
		}

		systemUserBo.setEmailAddressVerified(1);
		systemUserBo.setEmailAddressVerificationDate(new Date());
		systemUserBo.setLastModifiedBy(CozarbServiceConstants.GLOBAL_SYSTEM_USER);
		systemUserBo.setLastModifiedDate(new Date());

		if (systemUserBo.getMobileNumberVerified() == 0) {
			verificationStatus = REGISTRATION_VERIFY_STATUS_EMAIL_ONLY_VERIFIED;
			cozarbLogger.debug("update systemUser of id {} marking email verification completed", systemUserId);
		} else {
			systemUserBo.setAccountStatus(STATUS_SYSTEM_USER_ACTIVATED);
			cozarbLogger.debug("update systemUser of id {} marking email verification completed and account activated",
					systemUserId);
		}
		userManagementDao.updateSystemUser(systemUserBo);

		return verificationStatus;
	}

	@Override
	public int verifyUserMobileNumber(int systemUserId, String mobileVerificationCode) {
		SystemUserBo systemUserBo = null;
		int verificationStatus = REGISTRATION_VERIFY_STATUS_ALL;

		systemUserBo = userManagementDao.getSystemUser(systemUserId);
		if (systemUserBo == null) {
			cozarbLogger.info("cannot find systemUser with id {} for verifying the mobile number verification code {}",
					systemUserId, mobileVerificationCode);
			throw new UserAccountNotFoundException("cannot find systemUser with id " + systemUserId);
		}

		if (systemUserBo.getAccountStatus().equals(STATUS_SYSTEM_USER_ACTIVATED)) {
			cozarbLogger.debug("systemUserId {} account has already active", systemUserId);
			throw new AccountAlreadyActivatedException("SystemUser already activated");
		} else if (systemUserBo.getMobileNumberVerified() == 1) {
			cozarbLogger.debug("mobile number already verified for system user {} ", systemUserId);
			throw new MobileAlreadyVerifiedException("User account mobile number already verified");
		}

		if (mobileVerificationCode.equals(systemUserBo.getMobileNumberVerificationCode()) == false) {
			cozarbLogger.info("mobile verification code mis-match for system user id {}", systemUserId);
			throw new VerificationCodeMisMatchException("mobile verification code not matched");
		}

		systemUserBo.setMobileNumberVerified(1);
		systemUserBo.setMobileNumberVerificationDate(new Date());
		systemUserBo.setLastModifiedBy(CozarbServiceConstants.GLOBAL_SYSTEM_USER);
		systemUserBo.setLastModifiedDate(new Date());

		if (systemUserBo.getEmailAddressVerified() == 0) {
			verificationStatus = REGISTRATION_VERIFY_STATUS_MOBILE_ONLY_VERIFIED;
			cozarbLogger.debug("update systemUser of id {} marking email verification completed", systemUserId);
		} else {
			systemUserBo.setAccountStatus(STATUS_SYSTEM_USER_ACTIVATED);
			cozarbLogger.debug("update systemUser of id {} marking email verification completed and account activated",
					systemUserId);
		}
		userManagementDao.updateSystemUser(systemUserBo);

		return verificationStatus;
	}

	@Override
	public SystemUserDetailsDto getSystemUserWithRoleByEmailAddress(String emailAddress) {
		UserRoleDto userRoleDto = null;
		SystemUserDto systemUserDto = null;
		SystemUserDetailsBo systemUserDetailsBo = null;
		SystemUserDetailsDto systemUserDetailsDto = null;
		try {
			systemUserDetailsBo = userManagementDao.getSystemUserWithRoleByEmailAddress(emailAddress);
			systemUserDto = new SystemUserDto();
			systemUserDto.setSystemUserId(systemUserDetailsBo.getSystemUserBo().getSystemUserId());
			systemUserDto.setEmailAddress(systemUserDetailsBo.getSystemUserBo().getEmailAddress());
			systemUserDto.setPassword(systemUserDetailsBo.getSystemUserBo().getPassword());
			systemUserDto.setMobileNumber(systemUserDetailsBo.getSystemUserBo().getMobileNumber());
			systemUserDto.setLastLoggedInDate(systemUserDetailsBo.getSystemUserBo().getLastLoggedInDate());
			systemUserDto.setAccountStatus(systemUserDetailsBo.getSystemUserBo().getAccountStatus());

			userRoleDto = new UserRoleDto();
			userRoleDto.setUserRoleId(systemUserDetailsBo.getUserRoleBo().getUserRoleId());
			userRoleDto.setUserRoleName(systemUserDetailsBo.getUserRoleBo().getUserRoleName());
			userRoleDto.setRoleCode(systemUserDetailsBo.getUserRoleBo().getRoleCode());
			userRoleDto.setStatus(systemUserDetailsBo.getUserRoleBo().getStatus());

			systemUserDetailsDto = new SystemUserDetailsDto(systemUserDto, userRoleDto);

		} catch (EmptyResultDataAccessException e) {
			throw new UserAccountNotFoundException("SystemUser not found for emailAddress " + emailAddress, e);
		}

		return systemUserDetailsDto;
	}

}
