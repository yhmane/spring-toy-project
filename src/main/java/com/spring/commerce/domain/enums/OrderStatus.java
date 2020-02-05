package com.spring.commerce.domain.enums;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
public enum OrderStatus {
    READY("주문준비"),
    SUCCESS("주문성공"),
    FAILURE("주문실패");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
