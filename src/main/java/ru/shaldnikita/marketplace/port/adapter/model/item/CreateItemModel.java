package ru.shaldnikita.marketplace.port.adapter.model.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import ru.shaldnikita.marketplace.domain.ItemCategory;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemModel {
    @NotNull
    private String ownerId;

    @NotNull
    private String name;

    @NotNull
    private ItemCategory category;

    @NotNull
    private String description;

    @NotNull
    private int price;

    @Nullable
    private Byte[] file;
}
