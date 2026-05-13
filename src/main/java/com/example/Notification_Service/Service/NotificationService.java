package com.example.Notification_Service.Service;

import com.example.Notification_Service.DTO.NotificationRequest;
import com.example.Notification_Service.DTO.NotificationResponse;
import com.example.Notification_Service.Entity.Notification;
import com.example.Notification_Service.Repository.NotificationRepository;
import com.example.Notification_Service.Mapper.NotificationMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    private final NotificationMapper mapper;

    @Transactional
    public NotificationResponse createNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .userId(request.getUserId())
                .message(request.getMessage())
                .isRead(false)
                .build();

        Notification savedNotification = repository.save(notification);

        return mapper.toResponse(savedNotification);
    }

    public List<NotificationResponse> getNotificationForUser(Long userId) {
        List<Notification> notifications = repository.findAllByUserIdOrderByCreatedAtDesc(userId);

        return notifications
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public void markAsRead(Long notificationId) {
        Notification notification = repository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Нотификации не найдена по id " + notificationId));

        notification.setRead(true);
    }
}
