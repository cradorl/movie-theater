package com.jpmc.theater.handler;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralExceptionHandlerTest {
    private final GeneralExceptionHandler handler = new GeneralExceptionHandler();

    @Test
    void allExceptionsHanding() {
        String message = "Something went wrong. Please, try again.";
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        ResponseEntity<String> actualResponseEntity = handler.allExceptionsHanding(new Exception());

        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
    }

}