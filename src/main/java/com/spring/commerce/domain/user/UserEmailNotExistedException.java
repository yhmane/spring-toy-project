package com.spring.commerce.domain.user;

/**
 * @author hwang-yunho on 2020. 3. 27.
 * @project commerce
 */
public class UserEmailNotExistedException extends RuntimeException {
    public UserEmailNotExistedException(String email) {
        super("UserEmailNotExistedException, email not exist " + email);
    }
}
