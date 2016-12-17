package com.orion10110.training.managertaxi.web.lang;

import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
public class UserDataLang {
	
	private List<Locale> userLocales;
	
	 public List<Locale> getUserLocales() {
		return userLocales;
	}
	public void setUserLocales(List<Locale> userLocales) {
		this.userLocales = userLocales;
	}
	public boolean hasUserLocales() {
		return !userLocales.isEmpty();
	}
	
}
