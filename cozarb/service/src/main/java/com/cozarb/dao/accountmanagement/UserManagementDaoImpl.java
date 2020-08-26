package com.cozarb.dao.accountmanagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cozarb.bo.accountmanagement.SystemUserBo;
import com.cozarb.bo.accountmanagement.SystemUserDetailsBo;
import com.cozarb.bo.accountmanagement.UserRoleBo;
import com.cozarb.service.logging.CozarbLogger;

@Repository
public class UserManagementDaoImpl implements UserManagementDao {
	private static final CozarbLogger cozarbLogger = CozarbLogger.getLogger(UserManagementDaoImpl.class);

	private final String SQL_INSERT_SYSTEM_USER = "INSERT INTO system_user (email_address, password, mobile_nbr, email_verification_code, mobile_nbr_verification_code, is_email_address_verified, is_mobile_nbr_verified, account_status, created_by, created_dt, last_modified_by, last_modified_dt, user_role_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
	private final String SQL_GET_USER_ROLE_ID_BY_ROLE_CODE = "select user_role_id from user_role where role_cd = ?";
	private final String SQL_COUNT_SYSTEM_USER_BY_EMAIL_ADDRESS = "select count(1) from system_user where email_address = ?";
	private final String SQL_GET_SYSTEM_USER_BY_SYSTEM_USER_ID = "select system_user_id, user_role_id, email_address, password, mobile_nbr, email_verification_code, mobile_nbr_verification_code, is_email_address_verified, is_mobile_nbr_verified, email_address_verification_dt, mobile_nbr_verification_dt, last_logged_in_dt, account_status, created_by, created_dt, last_modified_by, last_modified_dt from system_user where system_user_id = ?";
	private final String SQL_UPDATE_SYSTEM_USER_BY_SYSTEM_USER_ID = "update system_user set user_role_id = ?, email_address = ?, password = ?, mobile_nbr = ?, is_email_address_verified = ?, is_mobile_nbr_verified = ?, email_address_verification_dt = ?, mobile_nbr_verification_dt = ?, last_logged_in_dt = ?, account_status = ?, last_modified_by = ?, last_modified_dt = ? where system_user_id = ?";
	private final String SQL_GET_SYSTEM_USER_DETAILS_BY_EMAIL_ADDRESS = "select su.system_user_id, su.user_role_id, su.email_address, su.password, su.mobile_nbr, su.email_verification_code, su.mobile_nbr_verification_code, su.is_email_address_verified, su.is_mobile_nbr_verified, su.email_address_verification_dt, su.mobile_nbr_verification_dt, su.last_logged_in_dt, su.account_status, su.created_by, su.created_dt, su.last_modified_by, su.last_modified_dt, ur.user_role_id, ur.user_role_nm, ur.role_cd, ur.status, ur.created_by, ur.created_dt, ur.last_modified_by, ur.last_modified_dt from system_user su inner join user_role ur on su.user_role_id = ur.user_role_id where email_address = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveCustomer(final SystemUserBo systemUser) {
		int systemUserId;
		KeyHolder keyHolder = null;

		cozarbLogger.debug("saving customer with email address: {}", systemUser.getEmailAddress());

		keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((con) -> {
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(SQL_INSERT_SYSTEM_USER, new String[] { "system_user_id" });
			pstmt.setString(1, systemUser.getEmailAddress());
			pstmt.setString(2, systemUser.getPassword());
			pstmt.setString(3, systemUser.getMobileNumber());
			pstmt.setString(4, systemUser.getEmailVerificationCode());
			pstmt.setString(5, systemUser.getMobileNumberVerificationCode());
			pstmt.setInt(6, systemUser.getEmailAddressVerified());
			pstmt.setInt(7, systemUser.getMobileNumberVerified());
			pstmt.setString(8, systemUser.getAccountStatus());
			pstmt.setString(9, systemUser.getCreatedBy());
			pstmt.setDate(10, new java.sql.Date(systemUser.getCreatedDate().getTime()));
			pstmt.setString(11, systemUser.getLastModifiedBy());
			pstmt.setDate(12, new java.sql.Date(systemUser.getLastModifiedDate().getTime()));
			pstmt.setInt(13, systemUser.getUserRoleId());

			return pstmt;
		}, keyHolder);
		systemUserId = keyHolder.getKey().intValue();
		cozarbLogger.debug("saved customer with id {}", systemUserId);

		return systemUserId;
	}

	@Override
	public int getUserRoleIdByRoleCode(String roleCode) {
		return jdbcTemplate.queryForObject(SQL_GET_USER_ROLE_ID_BY_ROLE_CODE, Integer.class, roleCode);
	}

	@Override
	public int countSystemUserByEmailAddress(String emailAddress) {
		return jdbcTemplate.queryForObject(SQL_COUNT_SYSTEM_USER_BY_EMAIL_ADDRESS, Integer.class, emailAddress);
	}

	@Override
	public SystemUserBo getSystemUser(int systemUserId) {
		return jdbcTemplate.queryForObject(SQL_GET_SYSTEM_USER_BY_SYSTEM_USER_ID, new SystemUserRowMapper(),
				systemUserId);
	}

	@Override
	public void updateSystemUser(SystemUserBo systemUser) {
		jdbcTemplate.update(SQL_UPDATE_SYSTEM_USER_BY_SYSTEM_USER_ID, systemUser.getUserRoleId(),
				systemUser.getEmailAddress(), systemUser.getPassword(), systemUser.getMobileNumber(),
				systemUser.getEmailAddressVerified(), systemUser.getMobileNumberVerified(),
				systemUser.getEmailAddressVerificationDate(), systemUser.getMobileNumberVerificationDate(),
				systemUser.getLastLoggedInDate(), systemUser.getAccountStatus(), systemUser.getLastModifiedBy(),
				systemUser.getLastModifiedDate(), systemUser.getSystemUserId());
	}

	@Override
	public SystemUserDetailsBo getSystemUserWithRoleByEmailAddress(String emailAddress) {
		return jdbcTemplate.queryForObject(SQL_GET_SYSTEM_USER_DETAILS_BY_EMAIL_ADDRESS,
				new SystemUserDetailsRowMapper(), emailAddress);
	}

	private final class SystemUserRowMapper implements RowMapper<SystemUserBo> {
		@Override
		public SystemUserBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return mapSystemUserBo(rs);
		}
	}

	private final class SystemUserDetailsRowMapper implements RowMapper<SystemUserDetailsBo> {
		@Override
		public SystemUserDetailsBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			SystemUserBo systemUserBo = null;
			UserRoleBo userRoleBo = null;
			SystemUserDetailsBo systemUserDetailsBo = null;

			systemUserBo = mapSystemUserBo(rs);
			userRoleBo = mapUserRoleBo(rs);
			systemUserDetailsBo = new SystemUserDetailsBo(systemUserBo, userRoleBo);
			return systemUserDetailsBo;
		}

	}

	private UserRoleBo mapUserRoleBo(ResultSet rs) throws SQLException {
		UserRoleBo userRoleBo = null;

		userRoleBo = new UserRoleBo();
		userRoleBo.setUserRoleId(rs.getInt(18));
		userRoleBo.setUserRoleName(rs.getString(19));
		userRoleBo.setRoleCode(rs.getString(20));
		userRoleBo.setStatus(rs.getString(21));
		userRoleBo.setCreatedBy(rs.getString(22));
		userRoleBo.setCreatedDate(rs.getDate(23));
		userRoleBo.setLastModifiedBy(rs.getString(24));
		userRoleBo.setLastModifiedDate(rs.getDate(25));

		return userRoleBo;
	}

	private SystemUserBo mapSystemUserBo(ResultSet rs) throws SQLException {
		SystemUserBo systemUserBo = null;

		systemUserBo = new SystemUserBo();
		systemUserBo.setSystemUserId(rs.getInt(1));
		systemUserBo.setUserRoleId(rs.getInt(2));
		systemUserBo.setEmailAddress(rs.getString(3));
		systemUserBo.setPassword(rs.getString(4));
		systemUserBo.setMobileNumber(rs.getString(5));
		systemUserBo.setEmailVerificationCode(rs.getString(6));
		systemUserBo.setMobileNumberVerificationCode(rs.getString(7));
		systemUserBo.setEmailAddressVerified(rs.getInt(8));
		systemUserBo.setMobileNumberVerified(rs.getInt(9));
		systemUserBo.setEmailAddressVerificationDate(rs.getDate(10));
		systemUserBo.setMobileNumberVerificationDate(rs.getDate(11));
		systemUserBo.setLastLoggedInDate(rs.getDate(12));
		systemUserBo.setAccountStatus(rs.getString(13));
		systemUserBo.setCreatedBy(rs.getString(14));
		systemUserBo.setCreatedDate(rs.getDate(15));
		systemUserBo.setLastModifiedBy(rs.getString(16));
		systemUserBo.setLastModifiedDate(rs.getDate(17));
		return systemUserBo;
	}
}
