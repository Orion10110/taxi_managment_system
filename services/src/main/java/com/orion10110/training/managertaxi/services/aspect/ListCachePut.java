package com.orion10110.training.managertaxi.services.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
/**
 * Анотация для добавления и обновления записи в кэше
 * @author Калач Артур
 *
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ListCachePut {
	/**
	 * Имя кэша
	 * @return Имя кэша
	 */
	@AliasFor("cacheNames")
	String value() default "";
	
	@AliasFor("value")
	String cacheNames() default "";

}
