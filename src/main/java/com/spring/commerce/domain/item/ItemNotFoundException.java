package com.spring.commerce.domain.item;

/**
 * @author hwang-yunho on 2020. 2. 20.
 * @project commerce
 */
public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id) {
        super("ItemNotFoundException, item id : " + id);
    }
}
