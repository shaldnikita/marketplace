package ru.shaldnikita.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String itemId;

    private String name;

    private String description;

    private int price;

    private int rating;

    @Lob
    private Byte[] file;

    public Item(String itemId, String name, String description, int price, int rating, Byte[] file) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.file = file;
    }
}
