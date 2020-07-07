package com.renzo.employee.config.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class NamesImpl implements ConstraintValidator<Names, Integer> {

  List<Integer> values;

  @Override
  public void initialize(Names constraintAnnotation) {
    values = Arrays.stream(constraintAnnotation.values()).boxed().collect(Collectors.toList());
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return values.contains(value);
  }
}
