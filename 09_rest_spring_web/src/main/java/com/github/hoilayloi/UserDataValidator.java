package com.github.hoilayloi;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
 *
 * @author halab
 */
public class UserDataValidator implements ConstraintValidator<UserData, UserRequest> {

    @Override
    public boolean isValid(UserRequest userRequest, ConstraintValidatorContext constraintValidatorContext) {
        if ("admin".equals(userRequest.getUsername())) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Can not create user with username is 'admin'")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
