package com.spring.commerce.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ItemTest {

    @Test
    public void constructor() {
        new Item(1L, "cap", 1000, 5);
    }
}