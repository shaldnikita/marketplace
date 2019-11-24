package ru.shaldnikita.marketplace.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;

/**
 * Комментарий: name, date, content, likes, image
 */
@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    private String commentId;

    private String name;

    private LocalDateTime date;

    private String content;

    private Integer rating;

    private Integer likes;

    @Lob
    private Byte[] image;

    private String itemId;

    private String authorId;

    public Comment(String commentId, String name, LocalDateTime date, String content, Integer rating, Integer likes, Byte[] image, String itemId, String authorId) {
        this.commentId = commentId;
        this.name = name;
        this.date = date;
        this.content = content;
        this.rating = rating;
        this.likes = likes;
        this.image = image;
        this.itemId = itemId;
        this.authorId = authorId;
    }
}
