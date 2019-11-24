package ru.shaldnikita.marketplace.port.adapter.model.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import ru.shaldnikita.marketplace.domain.ItemCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemModel {
    private String ownerId;

    private String name;

    private ItemCategory category;

    private String description;

    private int price;

    @Nullable
    private Byte[] file;
}
