package com.example.managementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExists extends RuntimeException {
    String messege;
    public EmailAlreadyExists(String messege){
        super(messege);
        this.messege = messege;
    }
}
