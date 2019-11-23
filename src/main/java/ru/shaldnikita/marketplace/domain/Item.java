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

    private String name;

    private ItemCategory category;

    private String description;

    private int price;

    private int rating;

    @OneToMany(mappedBy = "item")
    private List<Comment> comments;

    @ManyToOne
    private User owner;

    @Lob
    private byte[] file;

    public Item(String itemId, String name, ItemCategory category, String description, int price, int rating, List<Comment> comments, User owner, byte[] file) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.comments = comments;
        this.owner = owner;
        this.file = file;
    }

    public Item(String itemId, String name, ItemCategory category, String description, int price, int rating, byte[] file) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.file = file;
    }
}
