package ru.shaldnikita.marketplace.port.adapter.model.comment;

import ru.shaldnikita.marketplace.application.model.Comment;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class CommentModelMapper {

    public static Comment map(CreateCommentModel comment) {
        return new Comment(
                null,
                comment.getName(),
                LocalDateTime.now(ZoneId.of("UTC+3")),
                comment.getContent(),
                0,
                0,
                comment.getImage(),
                comment.getItemId(),
                comment.getAuthorId()
        );
    }

    public static CommentModel unmap(Comment comment) {
        return new CommentModel(
                comment.getCommentId(),
                comment.getName(),
                comment.getDate(),
                comment.getContent(),
                comment.getRating(),
                comment.getLikes(),
                comment.getImage(),
                comment.getItemId(),
                comment.getAuthorId()
        );
    }
}
