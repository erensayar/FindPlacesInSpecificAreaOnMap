package com.erensayar.FindPlacesApi.error.exception;

import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.UNSUPPORTED_MEDIA_TYPE_ERROR_CODE;
import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.UNSUPPORTED_MEDIA_TYPE_ERROR_MESSAGE;

public class UnsupportedMediaTypeException extends BaseException {

    private static final String ERROR_CODE = UNSUPPORTED_MEDIA_TYPE_ERROR_CODE;
    private static final String ERROR_MESSAGE = UNSUPPORTED_MEDIA_TYPE_ERROR_MESSAGE;

    public UnsupportedMediaTypeException() {
        super(ERROR_CODE, ERROR_MESSAGE);
    }

    public UnsupportedMediaTypeException(final String errCode, final String errorMessage) {
        super(errCode, errorMessage);
    }

}
