package com.soundwave.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soundwave.app.model.Reactions;

public interface ReactionsRepository extends JpaRepository<Reactions, Long> {
    // Custom query methods (if needed) can be defined here
}
