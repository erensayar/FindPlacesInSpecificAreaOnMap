package com.erensayar.FindPlacesApi.error.exception;

// Default Errors. They can be override.
public final class ExceptionConstants {

    static final String EXCEPTION_CODE = "0000";
    static final String EXCEPTION_MESSAGE = "Error!";

    static final String BAD_REQUEST_ERROR_CODE                = "0001";
    static final String BAD_REQUEST_ERROR_MESSAGE             = "Bad Request";
    static final String NOT_FOUND_ERROR_CODE                  = "0002";
    static final String NOT_FOUND_ERROR_MESSAGE               = "Not Found";
    public static final String CONFLICT_ERROR_CODE            = "0003";
    public static final String CONFLICT_ERROR_MESSAGE         = "Content Conflict";
    static final String UNSUPPORTED_MEDIA_TYPE_ERROR_CODE     = "0004";
    static final String UNSUPPORTED_MEDIA_TYPE_ERROR_MESSAGE  = "Unsupported Media Type";
    static final String INTERNAL_SERVER_ERROR_CODE            = "0005";
    static final String INTERNAL_SERVER_ERROR_MESSAGE         = "Internal Server Error";
    public static final String VALIDATION_ERROR_CODE          = "0006";
    public static final String VALIDATION_ERROR_MESSAGE       = "Not Valid Error";
    static final String OK_CODE                               = "0007";
    static final String OK_MESSAGE                            = "Checked but something is wrong";


}
