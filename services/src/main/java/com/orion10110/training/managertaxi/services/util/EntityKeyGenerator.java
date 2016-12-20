package com.orion10110.training.managertaxi.services.util;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import com.orion10110.taximanager.datamodel.AbstractModel;
/**
 * Генератор ключей для кэширования по экземпляру
 * @author Калач Артур
 *
 */
@Component
public class EntityKeyGenerator  implements KeyGenerator {
	@Override
	public Object generate(Object target, Method method, Object... params) {
		String className = target.getClass().getSimpleName();	// Получаем имя класса
		AbstractModel param = (AbstractModel)params[0];	//Получаем экземляр
		return String.format("%s%s", className,param.getId()); //Генерируем ключ
	}
}