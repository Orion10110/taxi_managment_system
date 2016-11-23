package com.orion10110.training.managertaxi.services.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheList {
	@AliasFor("cacheNames")
	String[] value() default {};
	
	@AliasFor("value")
	String[] cacheNames() default {};
	
	String keyGenerator() default "";
}
