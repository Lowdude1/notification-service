package com.example.Notification_Service.Service;

import com.example.Notification_Service.DTO.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisNotificationListener {

    private final NotificationService notificationService;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    public void onMessage(String message, String channel) {
        try {
            NotificationRequest request = objectMapper.readValue(message, NotificationRequest.class);
            notificationService.createNotification(request);
            System.out.println("Получен JSON: " + request);
        } catch (Exception e) {
            System.out.println("Ошибка парсинга JSON: " + e.getMessage());
        }
    }
}
