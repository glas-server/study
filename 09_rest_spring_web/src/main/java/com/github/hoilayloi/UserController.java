package com.github.hoilayloi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 *
 * @author halab
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {

    public static final Map<String, User> USERS = new HashMap<>();

    static {
        USERS.put("angel", new User("angel", "123456", 20));
        USERS.put("huongntt", new User("huongntt", "123456", 18));
        USERS.put("thanhnv", new User("thanhnv", "123456", 18));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody @Validated UserRequest userRequest
    ) {
        User user = ModelMapperUtils.toObject(userRequest, User.class);
        USERS.put(user.getUsername(), user);
        return new ResponseEntity<>(ModelMapperUtils.toObject(user, UserResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listUsers(
            @RequestParam(value = "age", required = false) Integer age,
            @RequestHeader(value = "key") String key
    ) {
        List<UserResponse> users = USERS.values().stream().filter(user -> {
            if (age != null) {
                return user.getAge() == age;
            }
            return true;
        }).map(user -> ModelMapperUtils.toObject(user, UserResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(new ListUserResponse(users), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserDetail(
            @PathVariable("username") String username
    ) {
        User user = USERS.get(username);
        if (user == null) {
            return new ResponseEntity<>(ErrorResponse.RESOURCE_NOT_FOUND ,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ModelMapperUtils.toObject(user, UserResponse.class), HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUserDetail(
            @PathVariable("username") String username,
            @RequestBody UserRequest userRequest
    ) {
        User user = USERS.get(username);
        if (user == null) {
            return new ResponseEntity<>(ErrorResponse.RESOURCE_NOT_FOUND ,HttpStatus.NOT_FOUND);
        }
        user.setAge(userRequest.getAge());
        return new ResponseEntity<>(ModelMapperUtils.toObject(user, UserResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(
            @PathVariable("username") String username,
            @RequestHeader(value = "key") String key
    ) {
        if ("halab".equals(key)) {
            return new ResponseEntity<>(ErrorResponse.PERMISSION_DENIED ,HttpStatus.FORBIDDEN);
        }

        User user = USERS.get(username);
        if (user == null) {
            return new ResponseEntity<>(ErrorResponse.RESOURCE_NOT_FOUND ,HttpStatus.NOT_FOUND);
        }
        USERS.remove(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
