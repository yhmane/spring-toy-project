package com.spring.commerce.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT a " +
            "FROM User a " +
            "ORDER BY a.id DESC")
    Stream<User> findAllDesc();

    Optional<User> findByEmail(String email);
}
