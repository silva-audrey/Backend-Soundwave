package com.soundwave.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soundwave.app.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query methods (if needed) can be defined here
}
