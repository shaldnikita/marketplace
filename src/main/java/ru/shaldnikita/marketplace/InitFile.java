package ru.shaldnikita.marketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.shaldnikita.marketplace.domain.Item;
import ru.shaldnikita.marketplace.domain.ItemRepository;

import java.util.UUID;

@Component
public class InitFile implements CommandLineRunner {


    @Autowired
    private ItemRepository repository;

    @Override
    public void run(String... args) {
        Item item1 = new Item(
                UUID.randomUUID().toString(),
                "Item1",
                "Item1 description",
                100000,
                0,
                new Byte[]{1, 2, 3}
        );

        Item item2 = new Item(
                UUID.randomUUID().toString(),
                "Item2",
                "Item2 description",
                200000,
                5,
                new Byte[]{1, 2, 3}
        );

        Item item3 = new Item(
                UUID.randomUUID().toString(),
                "Item3",
                "Item3 description",
                300000,
                3,
                new Byte[]{1, 2, 3}
        );

        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
    }
}
