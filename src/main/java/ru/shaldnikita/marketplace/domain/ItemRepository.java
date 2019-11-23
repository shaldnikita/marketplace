package ru.shaldnikita.marketplace.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByItemId(String itemId);
}
