package ru.shaldnikita.marketplace.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaldnikita.marketplace.domain.Comment;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByCommentId(String commentId);
}
