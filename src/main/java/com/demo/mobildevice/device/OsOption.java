package com.demo.mobildevice.device;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = OsOptionValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OsOption {

	String message() default "{mobildevice.constraints.os.OsOption.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
