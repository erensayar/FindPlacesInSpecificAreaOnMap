package com.erensayar.FindPlacesApi.error.exception;

import lombok.Builder;
import lombok.Getter;

import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.EXCEPTION_CODE;
import static com.erensayar.FindPlacesApi.error.exception.ExceptionConstants.EXCEPTION_MESSAGE;

@Builder
@Getter
public class BaseException extends RuntimeException {

    @Builder.Default
    private String errorCode = EXCEPTION_CODE;

    @Builder.Default
    private String errorMessage = EXCEPTION_MESSAGE;

    public BaseException() {
        this.errorCode = EXCEPTION_CODE;
        this.errorMessage = EXCEPTION_MESSAGE;
    }

    public BaseException(final String errCode, final String errorMessage) {
        this.errorCode = errCode;
        this.errorMessage = errorMessage;
    }

}
