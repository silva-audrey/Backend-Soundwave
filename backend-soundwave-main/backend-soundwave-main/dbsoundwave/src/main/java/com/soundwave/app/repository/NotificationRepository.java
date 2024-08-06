package com.soundwave.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soundwave.app.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Custom query methods (if needed) can be defined here
}
