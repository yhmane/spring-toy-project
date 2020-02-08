package com.spring.commerce.domain;

import org.junit.Test;

public class OrderedItemTest {

    @Test
    public void constructor() {
        Item item = new Item(1L, "cap", 500, 3);

        new OrderItem(1L, item, 5000, 3);
    }
}