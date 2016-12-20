package com.orion10110.taximanager.datamodel.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * Анотация для определения игнорируемых полей
 * 
 * @author Калач Артур
 *
 */
@Documented
@Inherited
@Retention(RUNTIME)
@Target(FIELD)
public @interface IgnoreField {

}
