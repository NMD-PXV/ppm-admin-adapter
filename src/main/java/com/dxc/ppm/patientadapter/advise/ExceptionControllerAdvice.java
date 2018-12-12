package com.dxc.ppm.patientadapter.advise;

import com.dxc.ppm.patientadapter.exception.PatientException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(PatientException.class)
    public ResponseEntity<String> personalInfoExceptionHandle(PatientException ex) {
        String message = ex.getResponse().name();
        return new ResponseEntity<>(message, ex.getResponse().getHttpStatus());
    }
}
