package com.soundwave.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soundwave.app.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // Custom query methods (if needed) can be defined here
}
