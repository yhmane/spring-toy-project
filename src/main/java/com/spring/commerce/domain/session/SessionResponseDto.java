package com.spring.commerce.domain.session;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hwang-yunho on 2020. 3. 28.
 * @project commerce
 */
@NoArgsConstructor
@Getter
@Setter
public class SessionResponseDto {

    private String accessToken;

    @Builder
    public SessionResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
