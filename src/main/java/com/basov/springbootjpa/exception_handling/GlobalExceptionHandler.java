package com.basov.springbootjpa.exception_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException (NoSuchException noSuchException){
        IncorrectData data = new IncorrectData();
        data.setInfo(noSuchException.getMessage());
        logger.info("NoSuchException has been thrown");
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException (NumberFormatException exception){
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());
        logger.info("NumberFormatException has been thrown");
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
