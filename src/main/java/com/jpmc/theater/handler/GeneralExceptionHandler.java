package com.jpmc.theater.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> allExceptionsHanding(Exception ex) {
        log.error("Received exception: {}", ex.getMessage());
        return new ResponseEntity<>("Something went wrong. Please, try again.", HttpStatus.NOT_FOUND);
    }
}
