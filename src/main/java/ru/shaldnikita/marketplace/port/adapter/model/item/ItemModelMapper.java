package ru.shaldnikita.marketplace.port.adapter.model.item;


import ru.shaldnikita.marketplace.application.model.Item;
import ru.shaldnikita.marketplace.port.adapter.model.comment.CommentModelMapper;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

public class ItemModelMapper {
    public static Item map(CreateItemModel item) {
        return new Item(
                UUID.randomUUID().toString(),
                item.getOwnerId(),
                item.getName(),
                item.getCategory(),
                item.getDescription(),
                item.getPrice(),
                null,
                item.getFile(),
                new ArrayList<>()
        );
    }

    public static ItemModel unmap(Item item) {
        return new ItemModel(
                item.getItemId(),
                item.getOwnerId(),
                item.getName(),
                item.getCategory(),
                item.getDescription(),
                item.getPrice(),
                item.getRating(),
                item.getFile(),
                item.getComments().stream().map(CommentModelMapper::unmap).collect(Collectors.toList())
        );
    }
}
