package com.dxc.ppmadminadapter.common;

import org.springframework.http.HttpStatus;

public enum AdminStorageError {
    PATIENT_NOT_FOUND(0, HttpStatus.NOT_FOUND);
    private final int code;
    private final HttpStatus httpStatus;

    AdminStorageError(int code, HttpStatus httpStatus) {
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
