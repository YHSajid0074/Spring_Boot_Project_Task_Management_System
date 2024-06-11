package com.example.managementSystem.Repository;

import com.example.managementSystem.Entity.enumm.status;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Projection for {@link com.example.managementSystem.Entity.User}
 */
public interface CustomUserResponseDTO {
    int getId();

    String getFirstName();

    String getLastName();

    String getUsername();

    String getEmail();

    List<TaskInfo> getTask();

    /**
     * Projection for {@link com.example.managementSystem.Entity.Task}
     */
    interface TaskInfo {
        int getId();

        String getTitle();

        status getTaskStatus();

        LocalDateTime getStartTime();

        LocalDateTime getEndTime();
    }
}