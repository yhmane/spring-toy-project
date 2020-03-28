package com.spring.commerce.interfaces;

import com.spring.commerce.applications.UserService;
import com.spring.commerce.domain.session.SessionRequestDto;
import com.spring.commerce.domain.session.SessionResponseDto;
import com.spring.commerce.domain.user.User;
import com.spring.commerce.utils.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author hwang-yunho on 2020. 3. 27.
 * @project commerce
 */
@CrossOrigin
@RestController
@AllArgsConstructor
public class SessionController {

    private JwtUtil jwtUtil;

    private UserService userService;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(
           @Valid @RequestBody SessionRequestDto resource
    ) throws URISyntaxException {

        String email = resource.getEmail();
        String password = resource.getPassword();

        User user = userService.authenticate(email, password);

        String accessToken = jwtUtil.createToken(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUserLevel()
        );

        String url = "/session";
        return ResponseEntity.created(new URI(url)).body(
                SessionResponseDto.builder()
                        .accessToken(accessToken)
                        .build());
    }
}
