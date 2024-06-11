package com.example.managementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)

public class NoUserExists extends RuntimeException {
    private String name;
    private String fieldName;
    private int fieldValue;



    public NoUserExists(String name, String fieldName, int fieldValue) {
      super(String.format("%s is not found with %s: %s",name,fieldName,fieldValue));
      this.name = name;
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
    }
}
