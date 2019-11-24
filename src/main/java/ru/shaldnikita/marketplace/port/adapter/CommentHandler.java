package ru.shaldnikita.marketplace.port.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shaldnikita.marketplace.application.CommentService;
import ru.shaldnikita.marketplace.port.adapter.model.comment.CommentModel;
import ru.shaldnikita.marketplace.port.adapter.model.comment.CommentModelMapper;
import ru.shaldnikita.marketplace.port.adapter.model.comment.CreateCommentModel;

@RestController
@RequiredArgsConstructor
public class CommentHandler {

    private final CommentService commentService;

    @GetMapping("comments/{id}")
    public CommentModel findById(@PathVariable("id") String commentId) {
        return CommentModelMapper.unmap(commentService.findByCommentId(commentId));
    }

    @PostMapping("comments")
    public CommentModel createComment(@RequestBody CreateCommentModel comment) {
        return CommentModelMapper.unmap(commentService.create(CommentModelMapper.map(comment)));
    }
}
