package ru.shaldnikita.marketplace.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shaldnikita.marketplace.application.exceptions.CommentNotFoundException;
import ru.shaldnikita.marketplace.application.exceptions.ItemNotFoundException;
import ru.shaldnikita.marketplace.application.model.Comment;
import ru.shaldnikita.marketplace.domain.repo.CommentRepository;
import ru.shaldnikita.marketplace.domain.repo.ItemRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ItemRepository itemRepository;

    public Comment findByCommentId(String commentId) {
        var comment = commentRepository.findByCommentId(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
        return new Comment(
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

    @Transactional
    public Comment create(Comment comment) {
        var commentId = UUID.randomUUID().toString();
        commentRepository.save(
                new ru.shaldnikita.marketplace.domain.Comment(
                        commentId,
                        comment.getName(),
                        comment.getDate(),
                        comment.getContent(),
                        0,
                        0,
                        comment.getImage(),
                        comment.getItemId(),
                        comment.getAuthorId()
                )
        );
        comment.setCommentId(commentId);

        var item = itemRepository.findByItemId(comment.getItemId()).orElseThrow(() -> new ItemNotFoundException(comment.getItemId()));
        item.getCommentIds().add(commentId);
        itemRepository.save(item);

        return comment;
    }
}
