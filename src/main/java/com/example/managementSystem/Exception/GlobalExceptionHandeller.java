package com.example.managementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
@ControllerAdvice
public class GlobalExceptionHandeller {
@ExceptionHandler(NoUserExists.class)
    public ResponseEntity<ErrorDeatils> handleResourseNotFoundException(NoUserExists exception, WebRequest webRequest){
ErrorDeatils errorDeatils = new ErrorDeatils(
        LocalDateTime.now(),
        exception.getMessage(),
        webRequest.getDescription(false),
        "User Not Found"

);
return new ResponseEntity<>(errorDeatils, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<ErrorDeatils> handleEmailAlreadyExistsException(EmailAlreadyExists exception, WebRequest webRequest){
        ErrorDeatils errorDeatils = new ErrorDeatils(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Email Already Exists"

        );
        return new ResponseEntity<>(errorDeatils, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDeatils>handleglobalexception(Exception exception, WebRequest webRequest){
        ErrorDeatils errorDeatils = new ErrorDeatils(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Internal Server Error"

        );
        return new ResponseEntity<>(errorDeatils, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
