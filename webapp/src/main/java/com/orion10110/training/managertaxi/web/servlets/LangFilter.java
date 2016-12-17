package com.orion10110.training.managertaxi.web.servlets;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;

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
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.orion10110.training.managertaxi.web.lang.UserDataLang;
@Component
public class LangFilter implements Filter {

	private UserDataLang userDataLang;
	@Autowired
	private ApplicationContext appContext;

	@Override
	public void init(FilterConfig config) throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		appContext = context;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		
		
		userDataLang = appContext.getBean(UserDataLang.class);
		final List<Locale> acceptedLocales = new ArrayList<>();
	    final String userLocale = req.getHeader("Accept-Language");
	    if (userLocale != null) {
	        final List<LanguageRange> ranges = Locale.LanguageRange.parse(userLocale);

	        if (ranges != null) {
	            ranges.forEach(languageRange -> {
	                final String localeString = languageRange.getRange();
	                final Locale locale = Locale.forLanguageTag(localeString);
	                acceptedLocales.add(locale);
	            });
	        }
	    }
	    userDataLang.setUserLocales(acceptedLocales);
	    chain.doFilter(request, response);
		

	}

	
	@Override
	public void destroy() {
	}

}
