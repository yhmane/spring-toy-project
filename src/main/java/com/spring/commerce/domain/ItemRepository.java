package com.spring.commerce.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item save(Item item);
}
