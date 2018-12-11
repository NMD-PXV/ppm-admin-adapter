package com.dxc.ppmadminadapter.advise;

import com.dxc.ppmadminadapter.exception.AdminException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(AdminException.class)
    public ResponseEntity<String> personalInfoExceptionHandle(AdminException ex) {
        String message = ex.getResponse().name();
        return new ResponseEntity<>(message, ex.getResponse().getHttpStatus());
    }
}
