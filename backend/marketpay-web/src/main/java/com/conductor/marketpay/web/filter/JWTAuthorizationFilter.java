package com.conductor.hackathon.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.entity.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.conductor.hackathon.web.security.AppUser;
import com.conductor.hackathon.web.security.DefaultUserDetailsService;
import com.conductor.hackathon.web.security.SecurityConstants;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private DefaultUserDetailsService userService;
	
	public JWTAuthorizationFilter(AuthenticationManager authManager, DefaultUserDetailsService userService) {
		super(authManager);
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(SecurityConstants.HEADER_STRING);

		if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			sendAccessDenied(res);
			chain.doFilter(req, res);
			return;
		}

		try {
			UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(req, res);
			
		} catch (TokenExpiredException e) {
			
			sendAccessDenied(res);
		}
	}

	private void sendAccessDenied(HttpServletResponse res) throws IOException {
		res.setStatus(HttpStatus.FORBIDDEN.value());
		res.setContentType(ContentType.APPLICATION_JSON.getMimeType());
		res.getWriter().append("{\"error\" : \" ACESSO NEGADO \"}");
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		if (token != null) {
			// parse the token.
			String username = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes())).build()
					.verify(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getSubject();

			if (username != null) {
				AppUser loadUser = (AppUser) userService.loadUserByUsername(username);
				return new UsernamePasswordAuthenticationToken(loadUser, token, loadUser.getAuthorities());
			}
			return null;
		}
		return null;
	}
}