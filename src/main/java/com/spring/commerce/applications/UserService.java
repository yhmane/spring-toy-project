package com.spring.commerce.applications;

import com.spring.commerce.domain.enums.UserLevel;
import com.spring.commerce.domain.user.User;
import com.spring.commerce.domain.user.UserRepository;
import com.spring.commerce.domain.user.UserRequestDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
@Service
@Transactional
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addUser(UserRequestDto dto) {

        LOGGER.info("UserService addUser param email : " + dto.getEmail());
        LOGGER.info("UserService addUser param name : " + dto.getName());
        LOGGER.info("UserService addUser param phoneNum : " + dto.getPhoneNum());

        // 추가시 일반사용자로 우선 등록됨
        dto.setUserLevel(UserLevel.NORMAL);

        String encodePassword = passwordEncoder.encode(dto.getPassword());
        return userRepository.save(dto.toEntity());
    }
}
