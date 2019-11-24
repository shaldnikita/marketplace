package ru.shaldnikita.marketplace.port.adapter.model.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import ru.shaldnikita.marketplace.domain.ItemCategory;
import ru.shaldnikita.marketplace.port.adapter.model.comment.CommentModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {

    private String itemId;

    private String ownerId;

    private String name;

    private ItemCategory category;

    private String description;

    private int price;

    private Integer rating;

    @Nullable
    private Byte[] file;

    private List<CommentModel> comments;
}
