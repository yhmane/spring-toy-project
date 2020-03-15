package com.spring.commerce.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item save(Item item);

    @Query("SELECT a " +
            "FROM Item a " +
            "ORDER BY a.id DESC")
    Stream<Item> findAllDesc();
}
