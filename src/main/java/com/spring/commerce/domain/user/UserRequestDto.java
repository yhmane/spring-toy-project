package com.spring.commerce.domain.user;

import com.spring.commerce.domain.enums.UserLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    private String email;

    private String name;

    private String password;

    private String phoneNum;

    private UserLevel userLevel;

    @Builder
    public UserRequestDto(String email, String name, String password, String phoneNum, UserLevel userLevel) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNum = phoneNum;
        this.userLevel = userLevel;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNum(phoneNum)
                .userLevel(userLevel)
                .build();
    }
}

