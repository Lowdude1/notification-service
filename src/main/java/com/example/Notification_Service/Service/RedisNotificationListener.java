package com.example.Notification_Service.Service;

import com.example.Notification_Service.DTO.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisNotificationListener {
    private final NotificationService notificationService;

    public void onMessage(String message, String channel) {
        NotificationRequest request = new NotificationRequest(1L, message);

        notificationService.createNotification(request);

        System.out.println("Уведомление успешно сохранено в БД");
    }
}
