package com.spring.commerce.domain.user;

/**
 * @author hwang-yunho on 2020. 3. 17.
 * @project commerce
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("UserNotFoundException, user id : " + id);
    }
}
