package com.erensayar.FindPlacesApi.error.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String errorType;
    private String errorCode;
    private String errorMessage;
}
