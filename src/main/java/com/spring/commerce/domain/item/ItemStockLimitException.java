package com.spring.commerce.domain.item;

/**
 * @author hwang-yunho on 2020. 2. 22.
 * @project commerce
 */
public class ItemStockLimitException extends RuntimeException {

    public ItemStockLimitException(Long id, int currentStock, int orderCount) {
        super("ItemStockLimitException, item id :  " + id + ", currentStock : " + currentStock + ", orderCount : " + orderCount);
    }
}
