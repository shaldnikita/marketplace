package ru.shaldnikita.marketplace.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.List;

@Entity
@Data
public class Item {

    @Id
    private Long id;

    private String itemId;

    private String name;

    private String description;

    private int price;

    private int rating;

    @Lob
    private List<Byte> file;
}
