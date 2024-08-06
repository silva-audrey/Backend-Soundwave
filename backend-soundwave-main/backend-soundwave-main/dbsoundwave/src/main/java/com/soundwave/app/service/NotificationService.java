package com.soundwave.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soundwave.app.model.Notification;
import com.soundwave.app.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification notificationDetails) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    notification.setPostId(notificationDetails.getPostId());
                    return notificationRepository.save(notification);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id " + id));
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
