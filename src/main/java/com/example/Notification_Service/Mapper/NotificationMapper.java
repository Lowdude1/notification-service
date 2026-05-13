package com.example.Notification_Service.Mapper;

import com.example.Notification_Service.DTO.NotificationResponse;
import com.example.Notification_Service.Entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificationMapper {
    NotificationResponse toResponse(Notification notification);
}
