package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.shaldnikita.marketplace.domain.*;
import ru.shaldnikita.marketplace.port.adapter.model.ItemModel;
import ru.shaldnikita.marketplace.port.adapter.model.Sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemHandler {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;

    @PostMapping("items")
    public String createItem(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("category") ItemCategory category,
                             @RequestParam("price") int price,
                             @RequestParam("ownerId") String ownerId,
                             @RequestParam("file") MultipartFile file) throws IOException {
        Item createdItem = itemRepository.save(
                new Item(
                        UUID.randomUUID().toString(),
                        name,
                        category,
                        description,
                        price,
                        0,
                        new ArrayList<Comment>(),
                        userRepository.findByUserId(ownerId),
                        file.getBytes()
                )
        );
        return createdItem.getItemId();
    }

    @GetMapping("items")
    public List<ItemModel> getItems(@RequestParam(value = "OrderBy", defaultValue = "ASCENDING") Sort sort,
                                    @RequestParam(value = "Category", required = false) ItemCategory category,
                                    @RequestParam(value = "MinRating", defaultValue = "0") int minRating) {
        return sort.sort().apply(itemRepository)
                .stream()
                .filter(item -> Objects.isNull(category) || item.getCategory() == category)
                .filter(item -> item.getRating() >= minRating)
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
        Item item = this.itemRepository.findByItemId(id);
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
