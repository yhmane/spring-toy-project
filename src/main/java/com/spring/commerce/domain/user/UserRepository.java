package com.spring.commerce.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
