package com.spring.commerce.domain.item;

/**
 * @author hwang-yunho on 2020. 2. 20.
 * @project commerce
 */
public class ItemOverlapException extends RuntimeException{
    public ItemOverlapException() {
        super("ItemNotFoundException, overlapped item id");
    }
}
