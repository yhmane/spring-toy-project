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
public class UserResponseDto {
    private String email;

    private String name;

    private String phoneNum;

    private UserLevel userLevel;

    @Builder
    public UserResponseDto(String email, String name, String phoneNum, UserLevel userLevel) {
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        this.userLevel = userLevel;
    }

    public UserResponseDto(User entity) {
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.phoneNum = entity.getPhoneNum();
        this.userLevel = entity.getUserLevel();
    }

}
