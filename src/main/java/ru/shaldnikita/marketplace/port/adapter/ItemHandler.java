package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.shaldnikita.marketplace.domain.Item;
import ru.shaldnikita.marketplace.domain.ItemCategory;
import ru.shaldnikita.marketplace.domain.ItemRepository;
import ru.shaldnikita.marketplace.port.adapter.model.ItemModel;
import ru.shaldnikita.marketplace.port.adapter.model.Sort;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController("/")
@RequiredArgsConstructor
public class ItemHandler {

    private final ItemRepository repository;

    @PostMapping("items")
    public String createItem(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("category") String category,
                             @RequestParam("price") int price,
                             @RequestParam("file") MultipartFile file) throws IOException {
        Item createdItem = repository.save(
            new Item(
                UUID.randomUUID().toString(),
                name,
                description,
                price,
                0,
                file.getBytes(),
                ItemCategory.valueOf(category)
            )
        );
        return createdItem.getItemId();
    }

    @GetMapping("items")
    public List<ItemModel> getItems(@RequestParam(value = "OrderBy", defaultValue = "ASCENDING") Sort sort,
                                    @RequestParam(value = "category", required = false) ItemCategory category) {
        return sort.sort().apply(repository)
            .stream()
            .filter(item -> Objects.isNull(category) || item.getCategory() == category )
            .map(item -> new ItemModel(
                item.getItemId(),
                item.getName(),
                item.getDescription(),
                item.getCategory().toString(),
                item.getPrice(),
                item.getRating(),
                item.getFile()
            ))
            .collect(Collectors.toList());
    }

    @GetMapping("items/categories")
    public ItemCategory[] getCategories() {
        return ItemCategory.values();
    }

    @GetMapping("items/{id}")
    public ItemModel getSingleItem(@PathVariable("id") String id) {
        Item item = repository.findByItemId(id);
        return new ItemModel(
            item.getItemId(),
            item.getName(),
            item.getDescription(),
            item.getCategory().toString(),
            item.getPrice(),
            item.getRating(),
            item.getFile()
        );
    }

}
