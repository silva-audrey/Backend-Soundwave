package com.soundwave.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soundwave.app.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Custom query methods (if needed) can be defined here
}
