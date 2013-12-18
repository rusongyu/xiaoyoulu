package com.ard.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class AutheticationFilter implements Filter {

	private Logger log = Logger.getLogger(AutheticationFilter.class);

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();
		String suffix = url.substring(url.indexOf(".") + 1);

		log.info("hello  url=" + url);
		// 手机端直接跳过 有自己的过滤器
		if (url.contains(".action")) {

			log.info("**************" + url);
		}

		if (url.contains("/Sendlogin.jsp") || url.contains("/login.jsp")
				|| url.contains("/images")
				|| url.contains("/loginRange.action")
				|| url.contains("/changePassword.action")
				|| url.contains("/loginout.action")) {
			chain.doFilter(request, response);
			return;
		}
		
		chain.doFilter(request, response);
		return;
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
