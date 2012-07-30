package com.cognicap.site.security;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang.StringUtils.isBlank;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * An incomplete implementation of Spring Security's UserDetailsService...
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger log = Logger
			.getLogger(UserDetailsServiceImpl.class);

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		if (isBlank(username)) {
			throw new UsernameNotFoundException("Empty username");
		}

		String password = username;
		Collection<GrantedAuthority> grantedAuthorities = toGrantedAuthorities(username);
		boolean enabled = true;
		boolean userNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean userNonLocked = true;

		return new org.springframework.security.core.userdetails.User( //
				username, password, //
				enabled, userNonExpired, //
				credentialsNonExpired, userNonLocked, //
				grantedAuthorities);
	}

	/**
	 * Implement your authorities retrieval mechanism here
	 */
	private Collection<GrantedAuthority> toGrantedAuthorities(String username) {
		log.warn("TODO: you should load your real user here...");
		if ("admin".equalsIgnoreCase(username)) {
			return toGrantedAuthorities("ROLE_USER", "ROLE_ADMIN");
		} else {
			return toGrantedAuthorities("ROLE_USER");
		}
	}

	private Collection<GrantedAuthority> toGrantedAuthorities(String... roles) {
		return toGrantedAuthorities(newArrayList(roles));
	}

	private Collection<GrantedAuthority> toGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> result = newArrayList();

		for (String role : roles) {
			result.add(new GrantedAuthorityImpl(role));
		}

		return result;
	}
}