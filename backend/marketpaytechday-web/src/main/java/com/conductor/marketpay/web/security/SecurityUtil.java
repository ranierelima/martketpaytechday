package com.conductor.marketpay.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtil {

	private SecurityUtil() {
	}

	public static AppUser getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth != null ? (AppUser) auth.getPrincipal() : null;
	}

	public static Long getUserId() {
		return Optional.ofNullable(getUser()).orElse(AppUser.NULL).getId();
	}
	
	public static GrantedAuthority getPermission() {
		Collection<GrantedAuthority> authorities = Optional.ofNullable(getUser()).orElse(AppUser.NULL).getAuthorities();
		return new ArrayList<>(authorities).get(0);
	}
}
