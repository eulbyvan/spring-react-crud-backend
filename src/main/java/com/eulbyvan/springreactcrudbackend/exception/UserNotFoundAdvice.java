package com.eulbyvan.springreactcrudbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 27/12/2022
 */

@RestControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> exceptionHandler(UserNotFoundException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("User not found", e.getMessage());
        return errorMap;
    }
}
