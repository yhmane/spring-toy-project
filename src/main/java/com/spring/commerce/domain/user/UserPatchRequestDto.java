package com.spring.commerce.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
@NoArgsConstructor
@Getter
@Setter
public class UserPatchRequestDto {

    @NotBlank(message = "이름을 입력하여 주세요")
    @Pattern(regexp = "[a-zA-Zㄱ-ㅎ가-힣\\s+]{1,20}", message = "한글, 영어 20자 이내로 이름을 입력하여 주세요")
    private String name;

    @NotBlank(message = "비밀번호를 입력하여 주세요")
    @Pattern(regexp = "[a-zA-Zㄱ-ㅎ가-힣0-9(!@#$%^&*.,)]{1,20}", message = "한글, 영어, 숫자 20자 이내로 비밀번호를 입력하여 주세요")
    private String password;

    @NotBlank(message = "전화번호를 입력하여 주세요")
    @Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자로 입력하여 주세요")
    private String phoneNum;
}
