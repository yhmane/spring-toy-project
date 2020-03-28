package com.spring.commerce.advice;

import com.spring.commerce.domain.user.UserEmailNotExistedException;
import com.spring.commerce.domain.user.UserEmailOverlapException;
import com.spring.commerce.domain.user.UserNotFoundException;
import com.spring.commerce.domain.user.UserPasswordWrongException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hwang-yunho on 2020. 3. 17.
 * @project commerce
 */
@RestControllerAdvice
public class UserErrorAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String handleNotFound(UserNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserEmailNotExistedException.class)
    public String handleEmailNotFound(UserEmailNotExistedException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserEmailOverlapException.class)
    public String handleOverlapEntity(UserEmailOverlapException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserPasswordWrongException.class)
    public String handlePasswordWrong(UserPasswordWrongException e) {
        return e.getMessage();
    }
}
