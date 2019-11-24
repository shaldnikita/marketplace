package ru.shaldnikita.marketplace.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaldnikita.marketplace.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByItemId(String itemId);

    List<Item> findAllByOrderByPriceAsc();

    List<Item> findAllByOrderByPriceDesc();
}
