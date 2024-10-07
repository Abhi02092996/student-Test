package com.api.exception;

import com.api.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    //    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<String> resourceNotFound(ResourceNotFoundException r){
//        return new ResponseEntity<>(r.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @ExceptionHandler(ResourceNotFoundException.class
    )
    public ResponseEntity<ErrorDto> resourceNotFoundException(ResourceNotFoundException r, WebRequest request) {
        ErrorDto error = new ErrorDto(r.getMessage(), new Date(), request.getDescription(true));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globleException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
