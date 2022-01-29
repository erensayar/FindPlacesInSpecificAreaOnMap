package com.erensayar.FindPlacesApi.error.exception;

import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.BAD_REQUEST_ERROR_CODE;
import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.BAD_REQUEST_ERROR_MESSAGE;

public class BadRequestException extends BaseException {

    private static final String ERROR_CODE = BAD_REQUEST_ERROR_CODE;
    private static final String ERROR_MESSAGE = BAD_REQUEST_ERROR_MESSAGE;

    public BadRequestException() {
        super(ERROR_CODE, ERROR_MESSAGE);
    }

    public BadRequestException(final String errCode, final String errorMessage) {
        super(errCode, errorMessage);
    }

    public BadRequestException(final String errorMessage) {
        super(BAD_REQUEST_ERROR_CODE, errorMessage);
    }

}
