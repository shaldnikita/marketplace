package ru.shaldnikita.marketplace.port.adapter.model;

import ru.shaldnikita.marketplace.domain.Item;
import ru.shaldnikita.marketplace.domain.ItemRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public enum Sort {
    ASCENDING {
        public Function<ItemRepository, List<Item>> sort() {
            return new Function<ItemRepository, List<Item>>() {
                @Override
                public List<Item> apply(ItemRepository itemRepository) {
                    return itemRepository.findAllByOrderByPriceAsc();
                }
            };
        }
    },
    DESCENDING {
        @Override
        public Function<ItemRepository, List<Item>> sort() {
            return new Function<ItemRepository, List<Item>>() {
                @Override
                public List<Item> apply(ItemRepository itemRepository) {
                    return itemRepository.findAllByOrderByPriceDesc();
                }
            };
        }
    };

    public abstract Function<ItemRepository, List<Item>> sort();
}
