package ru.shaldnikita.marketplace.port.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemModel {
    private String name;

    private String description;

    private int price;

    private int rating;

    private Byte[] file;
}
