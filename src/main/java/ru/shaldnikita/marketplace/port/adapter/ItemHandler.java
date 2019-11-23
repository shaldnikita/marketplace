package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.shaldnikita.marketplace.domain.Item;
import ru.shaldnikita.marketplace.domain.ItemRepository;
import ru.shaldnikita.marketplace.port.adapter.model.ItemModel;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController("/")
@RequiredArgsConstructor
public class ItemHandler {

    private final ItemRepository repository;

    @PostMapping("items")
    public String createItem(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") int price,
                             @RequestParam("file") MultipartFile file) throws IOException {
        Item createdItem = repository.save(
                new Item(
                        UUID.randomUUID().toString(),
                        name,
                        description,
                        price,
                        0,
                        file.getBytes()
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
