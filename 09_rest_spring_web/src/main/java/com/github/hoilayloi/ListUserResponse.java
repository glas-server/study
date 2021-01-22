package com.github.hoilayloi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
 *
 * @author halab
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUserResponse {

    List<UserResponse> users;
}
