package com.erensayar.FindPlacesApi.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "google.places-api.nearby-search")
public class GooglePlacesApiConstant {
    private String baseLink;
    private String objectDataFormat;
}
