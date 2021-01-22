package com.github.hoilayloi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *
 * @author halab
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private int age;
}
