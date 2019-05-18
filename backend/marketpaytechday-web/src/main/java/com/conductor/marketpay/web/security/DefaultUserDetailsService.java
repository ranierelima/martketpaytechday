package com.conductor.marketpay.web.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(DefaultUserDetailsService.class);

	private static final String USER_SQL = "select id, email, password, permission from users where email = ? and active = 1";

	@Autowired
	private DataSource dataSource;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("Looking for {}", username);

		try (Connection conx = dataSource.getConnection(); PreparedStatement ps = conx.prepareStatement(getUserSQL())) {

			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.next()) {
					throw new UsernameNotFoundException("Username not found: " + username);
				}

				return createUserDetails(rs);
			}
		} catch (SQLException e) {
			throw new UsernameNotFoundException("Error when trying to retrieve the user " + username, e);
		}
	}

	protected UserDetails createUserDetails(ResultSet rs) throws SQLException {
		
		Long id = rs.getLong(1);
		String dbusername = rs.getString(2);
		String password = rs.getString(3);
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(rs.getString(4)));

		return new AppUser(id, dbusername, password, authorities);
	}

	protected String getUserSQL() {
		return USER_SQL;
	}
}