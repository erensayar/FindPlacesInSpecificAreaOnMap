package com.erensayar.FindPlacesApi.error.exception;

import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.CONFLICT_ERROR_CODE;
import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.CONFLICT_ERROR_MESSAGE;

public class ConflictException extends BaseException {

    private static final String ERROR_CODE = CONFLICT_ERROR_CODE;
    private static final String ERROR_MESSAGE = CONFLICT_ERROR_MESSAGE;

    public ConflictException() {
        super(ERROR_CODE, ERROR_MESSAGE);
    }

    public ConflictException(final String errorMessage) {
        super(ERROR_CODE, errorMessage);
    }

    public ConflictException(final String errCode, final String errorMessage) {
        super(errCode, errorMessage);
    }

}
