package com.dxc.ppm.patientadapter.exception;

import com.dxc.ppm.patientadapter.common.PatientStorageError;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PatientException extends RuntimeException {
    private final PatientStorageError response;

    public PatientException(PatientStorageError response) {
        this(response, null, new Object[0]);
    }

    public PatientException(PatientStorageError response, Throwable cause, Object... params) {
        super(response + Arrays.stream(params).map(Object::toString).collect(Collectors.joining(";", "{", "}")));
        this.response = response;
    }

    public PatientException(PatientStorageError response, Object... params) {
        this(response, null, params);
    }

    public PatientStorageError getResponse() {
        return response;
    }
}