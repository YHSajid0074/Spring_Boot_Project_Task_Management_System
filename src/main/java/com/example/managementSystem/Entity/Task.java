package com.example.managementSystem.Entity;

import com.example.managementSystem.Entity.enumm.status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    status taskStatus;
    LocalDateTime startTime;
    LocalDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
