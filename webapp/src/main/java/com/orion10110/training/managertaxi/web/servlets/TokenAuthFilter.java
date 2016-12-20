package com.orion10110.training.managertaxi.web.servlets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.orion10110.taximanager.datamodel.UserModel;
import com.orion10110.training.managertaxi.services.components.UserDataToken;
import com.orion10110.training.managertaxi.services.security.JwtAuthentication;
import com.orion10110.training.managertaxi.services.security.TokenAuthentication;

public class TokenAuthFilter implements Filter {

	private UserDataToken userDataToken;
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private TokenAuthentication tokenAuthentication;

	@Override
	public void init(FilterConfig config) throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		appContext = context;
		tokenAuthentication =appContext.getBean(TokenAuthentication.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		
		
		userDataToken = appContext.getBean(UserDataToken.class);
		String header = req.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}

		String authToken = header.substring(7);

		UserModel user= tokenAuthentication.parse(authToken);
		
		if (user !=null) {
			userDataToken.setUserModel(user);
			String usToken = tokenAuthentication.create( user, 3600*60*5);
			res.setHeader("Authorization", "Bearer " + usToken);
			chain.doFilter(request, response);
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}

	}

	
	@Override
	public void destroy() {
	}

}
