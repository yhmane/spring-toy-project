package com.spring.commerce.applications;

import com.spring.commerce.domain.enums.UserLevel;
import com.spring.commerce.domain.user.User;
import com.spring.commerce.domain.user.UserRepository;
import com.spring.commerce.domain.user.UserRequestDto;
import com.spring.commerce.domain.user.UserResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UserResponseDto> list() {
        List<UserResponseDto> list = userRepository.findAllDesc()
                .map(UserResponseDto::new).collect(Collectors.toList());
        return list;
    }

    public UserResponseDto getUser(Long id) throws Exception {
        // TODO 사용자 없을때  Exception 처리
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException());

        LOGGER.info("UserService getUser user email : " + user.getEmail());
        LOGGER.info("UserService getUser user name : " + user.getName());

        return UserResponseDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .phoneNum(user.getPhoneNum())
                .userLevel(user.getUserLevel())
                .build();
    }

    public User addUser(UserRequestDto dto) throws Exception {

        LOGGER.info("UserService addUser param email : " + dto.getEmail());
        LOGGER.info("UserService addUser param name : " + dto.getName());
        LOGGER.info("UserService addUser param phoneNum : " + dto.getPhoneNum());

        // email 중복 에러
        Optional<User> existed = userRepository.findByEmail(dto.getEmail());
        if(existed.isPresent()) {
            // TODO 이메일 중복에러 처리
            throw new Exception("이메일 중복 에러 : " + dto.getEmail());
        }

        // 추가시 일반사용자로 우선 등록됨
        dto.setUserLevel(UserLevel.NORMAL);

        String encodePassword = passwordEncoder.encode(dto.getPassword());
        return userRepository.save(dto.toEntity());
    }

}
