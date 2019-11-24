package ru.shaldnikita.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String itemId;

    private String ownerId;

    private String name;

    private ItemCategory category;

    private String description;

    private int price;

    private int rating;

    @Lob
    private Byte[] file;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> commentIds;


    public Item(String itemId, String ownerId, String name, ItemCategory category, String description, int price, int rating, Byte[] file, List<String> commentIds) {
        this.itemId = itemId;
        this.ownerId = ownerId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.file = file;
        this.commentIds = commentIds;
    }

    public Item(String itemId, String ownerId, String name, ItemCategory category, String description, int price, int rating, Byte[] file) {
        this.itemId = itemId;
        this.ownerId = ownerId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.file = file;
    }
}
