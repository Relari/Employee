package com.renzo.employee.config.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NamesImpl.class)
public @interface Names {

  String message() default "";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

  int[] values() default {};
}
