package com.spring.commerce.domain.user;

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
public class UserPatchRequestDto {

    private String name;

    private String password;

    private String phoneNum;
}
