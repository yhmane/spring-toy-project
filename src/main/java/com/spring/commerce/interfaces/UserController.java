package com.spring.commerce.interfaces;

import com.spring.commerce.applications.UserService;
import com.spring.commerce.domain.user.User;
import com.spring.commerce.domain.user.UserRequestDto;
import com.spring.commerce.domain.user.UserResponseDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
@RestController
@AllArgsConstructor
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    private UserService userService;

    @GetMapping("/users")
    public List<UserResponseDto> list() {
        return userService.list();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable Long id) throws Exception {
        LOGGER.info("UserController GET /users param id : " + id);
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody UserRequestDto dto) throws Exception {
        LOGGER.info("UserController POST /users param email : " + dto.getEmail());
        LOGGER.info("UserController POST /users param name : " + dto.getName());
        LOGGER.info("UserController POST /users param phoneNum : " + dto.getPhoneNum());

        User user = userService.addUser(dto);

        String url = "/users/" + user.getId();

        return ResponseEntity.created(new URI(url)).body("{}");
    }

}
