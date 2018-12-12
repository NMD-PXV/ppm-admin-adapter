package com.dxc.ppm.patientadapter.common;

import org.springframework.http.HttpStatus;

public enum PatientStorageError {
    PATIENT_NOT_FOUND(0, HttpStatus.NOT_FOUND);
    private final int code;
    private final HttpStatus httpStatus;

    PatientStorageError(int code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
