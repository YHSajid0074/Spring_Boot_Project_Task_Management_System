package com.example.managementSystem.Entity.enumm;

public enum status {
    PENDING(0),
    DONE(1);
    private int value;
    private status(int value) {
        this.value = value;
    }
}
