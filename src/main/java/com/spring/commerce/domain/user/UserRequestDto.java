package com.spring.commerce.domain.user;

import com.spring.commerce.domain.enums.UserLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {

    @NotBlank(message = "이메일을 입력하여 주세요")
    @Email(message = "이메일 양식으로 입력하여 주세요")
    private String email;

    @NotBlank(message = "이름을 입력하여 주세요")
    @Pattern(regexp = "[a-zA-Zㄱ-ㅎ가-힣\\s+]{1,20}", message = "한글, 영어 20자 이내로 이름을 입력하여 주세요")
    private String name;

    @NotBlank(message = "비밀번호를 입력하여 주세요")
    @Pattern(regexp = "[a-zA-Zㄱ-ㅎ가-힣0-9(!@#$%^&*.,)]{1,20}", message = "한글, 영어, 숫자 20자 이내로 비밀번호를 입력하여 주세요")
    private String password;

    @NotBlank(message = "전화번호를 입력하여 주세요")
    @Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자로 입력하여 주세요")
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

