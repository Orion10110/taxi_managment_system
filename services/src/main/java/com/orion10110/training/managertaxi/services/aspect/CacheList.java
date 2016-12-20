package com.orion10110.training.managertaxi.services.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
/**
 * Аннотация для определения кэширования Списка объектов по "одному"
 * 
 * @author Калач Артур
 *
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheList {
	/**
	 * Имя кэша
	 * @return Имя кэша
	 */
	@AliasFor("cacheNames")
	String value() default "";
	
	@AliasFor("value")
	String cacheNames() default "";
	/**
	 * Название класса генератора "ключей"
	 * @return имя класса
	 */
	String keyGenerator() default "";
}
