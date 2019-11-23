package ru.shaldnikita.marketplace.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.OrderBy;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByItemId(String itemId);

    List<Item> findAllByOrderByPriceAsc();

    List<Item> findAllByOrderByPriceDesc();
}
