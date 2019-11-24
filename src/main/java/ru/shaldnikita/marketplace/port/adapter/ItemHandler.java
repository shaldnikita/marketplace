package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.marketplace.application.ItemService;
import ru.shaldnikita.marketplace.domain.ItemCategory;
import ru.shaldnikita.marketplace.port.adapter.model.Sort;
import ru.shaldnikita.marketplace.port.adapter.model.item.CreateItemModel;
import ru.shaldnikita.marketplace.port.adapter.model.item.ItemModel;
import ru.shaldnikita.marketplace.port.adapter.model.item.ItemModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ItemHandler {

    private final ItemService itemService;

    @PostMapping("items")
    public ItemModel createItem(@RequestBody CreateItemModel item) {
        return ItemModelMapper.unmap(itemService.create(ItemModelMapper.map(item)));
    }

    @GetMapping("items")
    public List<ItemModel> getItems(@RequestParam(value = "orderByPrice", defaultValue = "ASCENDING") Sort sort,
                                    @RequestParam(value = "category", required = false) ItemCategory category,
                                    @RequestParam(value = "minRating", defaultValue = "0") int minRating) {
        return itemService.findAllSorted(sort, category, minRating).stream().map(ItemModelMapper::unmap).collect(Collectors.toList());
    }

    @GetMapping("items/categories")
    public ItemCategory[] getCategories() {
        return ItemCategory.values();
    }

    @GetMapping("items/{id}")
    public ItemModel getSingleItem(@PathVariable("id") String itemId) {
        return ItemModelMapper.unmap(itemService.findByItemId(itemId));
    }

}
