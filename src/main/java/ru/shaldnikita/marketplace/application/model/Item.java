package ru.shaldnikita.marketplace.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import ru.shaldnikita.marketplace.domain.ItemCategory;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String itemId;

    private String ownerId;

    private String name;

    private ItemCategory category;

    private String description;

    private int price;

    @Nullable
    private Integer rating;

    @Nullable
    private Byte[] file;

    private List<Comment> comments;
}
