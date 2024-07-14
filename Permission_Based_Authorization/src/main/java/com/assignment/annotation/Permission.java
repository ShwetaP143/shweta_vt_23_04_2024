package com.assignment.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.assignment.enums.LogicEnum;
import com.assignment.enums.PermissionsEnum;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
	 PermissionsEnum[] permissions();
	    LogicEnum type();
}
