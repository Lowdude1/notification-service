package com.example.Notification_Service.Controller;

import com.example.Notification_Service.DTO.NotificationRequest;
import com.example.Notification_Service.DTO.NotificationResponse;
import com.example.Notification_Service.Service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificationResponse createdNotification(@RequestBody @Valid NotificationRequest request) {
        return service.createNotification(request);
    }

    @GetMapping("/user/{userId}")
    public List<NotificationResponse> getByUser(@PathVariable Long userId) {
        return service.getNotificationForUser(userId);
    }

    @PatchMapping("/{notificationId}/read")
    public void markAsRead(@PathVariable Long notificationId) {
        service.markAsRead(notificationId);
    }
}
