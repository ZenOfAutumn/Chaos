package com.zen.autumn.learn.base.reflect.annotation;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value=FIELD)
public @interface Transfer {
	
	String source();
	
	Class<?> handle() ;

}
