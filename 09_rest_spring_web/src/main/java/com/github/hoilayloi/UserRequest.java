package com.github.hoilayloi;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/*
 *
 * @author halab
 */
@Data
@UserData
public class UserRequest {

    @Size(min = 5, message = "Username length must be at least 5")
    @NotBlank(message = "Username can not be blank")
    private String username;

    @NotBlank(message = "Password can not be blank")
    @Min(value = 6, message = "Password length must be at least 6")
    @Pattern(regexp = "[0-9a-zA-Z]+", message = "Password must be alphanumeric")
    private String password;

//    @Min(value = 18, message = "Age must be at least 18")
//    @NotNull(message = "Age can not be null")
    @Age
    private Integer age;
}
