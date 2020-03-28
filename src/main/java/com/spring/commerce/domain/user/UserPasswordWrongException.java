package com.spring.commerce.domain.user;

/**
 * @author hwang-yunho on 2020. 3. 28.
 * @project commerce
 */
public class UserPasswordWrongException extends RuntimeException {
    public UserPasswordWrongException() {
        super("UserPasswordWrongException, password not correct");
    }
}
