package ru.shaldnikita.marketplace.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String commentId;

    private String name;

    private LocalDateTime date;

    private String content;

    private Integer rating;

    private int likes;

    @Nullable
    private Byte[] image;

    private String itemId;

    private String authorId;
}
