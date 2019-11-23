package ru.shaldnikita.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Комментарий: name, date, content, likes, image
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    private String commentId;

    private String name;

    private LocalDateTime date;

    private String content;

    private int likes;

    private byte[] image;

    public Comment(String commentId, String name, LocalDateTime date, String content, int likes, byte[] image) {
        this.commentId = commentId;
        this.name = name;
        this.date = date;
        this.content = content;
        this.likes = likes;
        this.image = image;
    }
}
