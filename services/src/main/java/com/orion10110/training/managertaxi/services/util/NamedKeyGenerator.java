package com.orion10110.training.managertaxi.services.util;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class NamedKeyGenerator implements KeyGenerator {
	@Override
	public Object generate(Object target, Method method, Object... params) {
		String className = target.getClass().getSimpleName();
		Long param = (Long) params[0];
		return String.format("%s%s", className,param);
	}
}