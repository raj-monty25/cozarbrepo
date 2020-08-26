package com.cozarb.customer.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cozarb.customer.security.bean.UserDetailsImpl;
import com.cozarb.dto.accountmanagement.SystemUserDetailsDto;
import com.cozarb.service.accountmanagement.UserManagementService;
import com.cozarb.service.exception.UserAccountNotFoundException;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserManagementService userManagementService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SystemUserDetailsDto systemUserDetailsDto = null;
		UserDetails userDetails = null;

		try {
			systemUserDetailsDto = userManagementService.getSystemUserWithRoleByEmailAddress(username);
			userDetails = new UserDetailsImpl(systemUserDetailsDto);
		} catch (UserAccountNotFoundException e) {
			throw new UsernameNotFoundException("username not found", e);
		}

		return userDetails;
	}

}
