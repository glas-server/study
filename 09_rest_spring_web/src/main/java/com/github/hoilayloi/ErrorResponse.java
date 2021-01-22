package com.github.hoilayloi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *
 * @author halab
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    int code;
    List<String> message;

    public static final ErrorResponse RESOURCE_NOT_FOUND
            = new ErrorResponse(ResponseCode.RESOURCE_NOT_FOUND, Collections.singletonList("Resource not found"));

    public static final ErrorResponse PERMISSION_DENIED
            = new ErrorResponse(ResponseCode.PERMISSION_DENIED, Collections.singletonList("Permission denied"));
}
