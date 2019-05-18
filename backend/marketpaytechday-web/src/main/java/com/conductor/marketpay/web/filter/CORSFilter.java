package com.conductor.marketpay.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
//		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		response.setHeader("Access-Control-Allow-Origin",  "*");

		if (!request.getMethod().equals("OPTIONS")) {

			response.setHeader("Access-Control-Expose-Headers",  "*");
			response.setHeader("Access-Control-Allow-Headers", "*");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Max-Age", "3600");
		} else {
			response.setHeader("Access-Control-Expose-Headers",  "content-type, x-access-token");
			response.setHeader("Access-Control-Allow-Headers", "content-type, x-access-token, "
			+ "access-control-allow-credentials, access-control-allow-origin, access-control-allow-methods, "
			+ "access-control-allow-headers, x-requested-with ");
			
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
