package ru.shaldnikita.marketplace.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shaldnikita.marketplace.application.exceptions.ItemNotFoundException;
import ru.shaldnikita.marketplace.application.model.Item;
import ru.shaldnikita.marketplace.domain.ItemCategory;
import ru.shaldnikita.marketplace.domain.repo.ItemRepository;
import ru.shaldnikita.marketplace.domain.repo.UserRepository;
import ru.shaldnikita.marketplace.port.adapter.model.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;

    private final CommentService commentService;

    public Item create(Item item) {
        var itemId = UUID.randomUUID().toString();
        itemRepository.save(
                new ru.shaldnikita.marketplace.domain.Item(
                        itemId,
                        item.getOwnerId(),
                        item.getName(),
                        item.getCategory(),
                        item.getDescription(),
                        item.getPrice(),
                        0,
                        item.getFile(),
                        new ArrayList<>()
                )
        );
        item.setItemId(itemId);
        return item;
    }

    public Item findByItemId(String itemId) {
        var item = itemRepository.findByItemId(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));
        return new Item(
                item.getItemId(),
                item.getOwnerId(),
                item.getName(),
                item.getCategory(),
                item.getDescription(),
                item.getPrice(),
                item.getRating(),
                item.getFile(),
                item.getCommentIds().stream()
                        .map(commentService::findByCommentId)
                        .collect(Collectors.toList())
        );
    }

    public List<Item> findAllSorted(Sort sort, ItemCategory category, int minRating) {
        return sort.sort().apply(itemRepository)
                .stream()
                .filter(item -> item.getCategory() == category)
                .filter(item -> item.getRating() >= minRating)
                .map(item -> new Item(
                        item.getItemId(),
                        item.getOwnerId(),
                        item.getName(),
                        item.getCategory(),
                        item.getDescription(),
                        item.getPrice(),
                        item.getRating(),
                        item.getFile(),
                        item.getCommentIds().stream()
                                .map(commentService::findByCommentId)
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }
}
