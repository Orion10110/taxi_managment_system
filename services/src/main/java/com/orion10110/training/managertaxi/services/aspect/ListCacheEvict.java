package com.orion10110.training.managertaxi.services.aspect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
/**
 * Анотация для удаления эллемента из списка кэша
 * 
 * @author Калач Артур
 *
 */
@Documented
@Inherited
@Retention(RUNTIME)
@Target(METHOD)
public @interface ListCacheEvict {
	/**
	 * Имя кэша
	 * @return имя кэша
	 */
	@AliasFor("cacheNames")
	String value() default "";
	
	@AliasFor("value")
	String cacheNames() default "";

}
