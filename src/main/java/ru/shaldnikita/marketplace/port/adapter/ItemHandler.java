package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.marketplace.domain.Item;
import ru.shaldnikita.marketplace.domain.ItemRepository;
import ru.shaldnikita.marketplace.port.adapter.model.CreateItemModel;
import ru.shaldnikita.marketplace.port.adapter.model.ItemModel;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController("/")
@RequiredArgsConstructor
public class ItemHandler {

    private final ItemRepository repository;

    @PostMapping("items")
    public String createItem(@RequestParam("item") CreateItemModel item) {
        Item createdItem = repository.save(
                new Item(
                        UUID.randomUUID().toString(),
                        item.getName(),
                        item.getDescription(),
                        item.getPrice(),
                        0,
                        item.getFile()
                )
        );
        return createdItem.getItemId();
    }

    @GetMapping("items")
    public List<ItemModel> getItems() {
        return repository.findAll().stream()
                .map(item -> new ItemModel(
                        item.getItemId(),
                        item.getName(),
                        item.getDescription(),
                        item.getPrice(),
                        item.getRating(),
                        item.getFile()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("items/{id}")
    public ItemModel getSingleItem(@PathVariable("id") String id) {
        Item item = repository.findByItemId(id);
        return new ItemModel(
                item.getItemId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getRating(),
                item.getFile()
        );
    }

}
