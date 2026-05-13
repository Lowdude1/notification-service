package com.example.Notification_Service.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    @NotBlank(message = "User Id cannot be empty")
    private Long userId;

    @NotBlank(message = "Message cannot be empty")
    private String message;
}
