package com.spring.commerce.domain.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hwang-yunho on 2020. 3. 27.
 * @project commerce
 */
@NoArgsConstructor
@Getter
@Setter
public class SessionRequestDto {

    private String email;

    private String password;
}
