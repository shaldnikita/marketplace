package ru.shaldnikita.marketplace.port.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {
    private String itemId;

    private String name;

    private String description;

    private String category;

    private int price;

    private int rating;

    private byte[] file;
}
