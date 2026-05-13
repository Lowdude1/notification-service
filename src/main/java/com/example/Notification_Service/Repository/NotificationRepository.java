package com.example.Notification_Service.Repository;

import com.example.Notification_Service.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByUserIdOrderByCreatedAtDesc(Long userId);

    List<Notification> findAllByUserIdAndIsReadFalse(Long userId);
}
