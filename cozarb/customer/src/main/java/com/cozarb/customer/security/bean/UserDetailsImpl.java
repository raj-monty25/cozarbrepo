package com.cozarb.customer.security.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cozarb.dto.accountmanagement.SystemUserDetailsDto;
import com.cozarb.service.constants.CozarbServiceConstants;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = -4934786133403629085L;
	protected int systemUserId;
	protected String username;
	protected String password;
	protected List<GrantedAuthority> authorities;
	protected String accountStatus;

	public UserDetailsImpl(SystemUserDetailsDto systemUserDetailsDto) {
		systemUserId = systemUserDetailsDto.getSystemUser().getSystemUserId();
		username = systemUserDetailsDto.getSystemUser().getEmailAddress();
		password = systemUserDetailsDto.getSystemUser().getPassword();
		accountStatus = systemUserDetailsDto.getSystemUser().getAccountStatus();

		authorities = Arrays.asList(new SimpleGrantedAuthority[] {
				new SimpleGrantedAuthority(systemUserDetailsDto.getUserRole().getRoleCode()) });
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountStatus.equals(CozarbServiceConstants.STATUS_SYSTEM_USER_LOCKED);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return accountStatus.equals(CozarbServiceConstants.STATUS_SYSTEM_USER_ACTIVATED);
	}

	public int getSystemUserId() {
		return systemUserId;
	}

	public void setSystemUserId(int systemUserId) {
		this.systemUserId = systemUserId;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
