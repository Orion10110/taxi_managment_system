package com.orion10110.training.managertaxi.services.components;

import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Объект языков пользователя
 * 
 * @author Калач Артур
 *
 */
@Component
@Scope(value = "request")
public class UserDataLang {
	/**
	 * Языки пользователя
	 */
	private List<Locale> userLocales;

	public List<Locale> getUserLocales() {
		return userLocales;
	}

	public void setUserLocales(List<Locale> userLocales) {
		this.userLocales = userLocales;
	}

	/**
	 * Наличие предпочитаемых языков
	 * @return наличие языков
	 */
	public boolean hasUserLocales() {
		return !userLocales.isEmpty();
	}

}
