package ru.shaldnikita.marketplace.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shaldnikita.marketplace.application.exceptions.CommentNotFoundException;
import ru.shaldnikita.marketplace.application.model.Comment;
import ru.shaldnikita.marketplace.domain.repo.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment findByCommentId(String commentId) {
        var comment =  commentRepository.findByCommentId(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
        return new Comment(

        );
    }
}
