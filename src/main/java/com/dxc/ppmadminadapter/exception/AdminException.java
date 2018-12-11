package com.dxc.ppmadminadapter.exception;

import com.dxc.ppmadminadapter.common.AdminStorageError;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AdminException extends RuntimeException {
    private final AdminStorageError response;

    public AdminException(AdminStorageError response) {
        this(response, null, new Object[0]);
    }

    public AdminException(AdminStorageError response, Throwable cause, Object... params) {
        super(response + Arrays.stream(params).map(Object::toString).collect(Collectors.joining(";", "{", "}")));
        this.response = response;
    }

    public AdminException(AdminStorageError response, Object... params) {
        this(response, null, params);
    }

    public AdminStorageError getResponse() {
        return response;
    }
}