package com.example.managementSystem.Dtos;

import com.example.managementSystem.Entity.User;
import com.example.managementSystem.Entity.enumm.status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record TaskDto(
        int id,
        @NotEmpty
        String title,
        @NotEmpty
        status taskStatus,
        @NotEmpty
        LocalDateTime startTime,
        @NotEmpty
        LocalDateTime endTime,
        Integer user_id) {
}
