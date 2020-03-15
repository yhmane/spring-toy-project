package com.spring.commerce.domain.enums;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
public enum UserLevel {
    NORMAL("일반사용자"),
    SELLER("판매자"),
    MANAGER("관리자");

    private String value;

    UserLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
