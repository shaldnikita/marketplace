package ru.shaldnikita.marketplace.port.adapter.model.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {

    private String commentId;

    private String name;

    private LocalDateTime date;

    private String content;

    private int rating;

    private int likes;

    private Byte[] image;

    private String itemId;

    private String authorId;
}
