package com.github.hoilayloi;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
 *
 * @author halab
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        if (age ==null) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Age can not be null")
                    .addConstraintViolation();
            return false;
        }
        if ( age < 18) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Age must be greater than or equal 18")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
