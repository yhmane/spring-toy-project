package com.spring.commerce.advice;

/**
 * @author hwang-yunho on 2020. 3. 17.
 * @project commerce
 */
public class UserEmailOverlapException extends RuntimeException {
    public UserEmailOverlapException(String email) {
        super("UserEmailOverlapException, user email : " + email);
    }
}
