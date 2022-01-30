package com.erensayar.FindPlacesApi.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "google.places-api")
public class GooglePlacesApiConstant {
    private String baseUrl;
    private String dataFormat;
    private Services services;

    @Getter
    @Setter
    public static class Services {
        private NearbySearch nearbySearch;

        @Getter
        @Setter
        public static class NearbySearch {
            private String url;
        }
    }

}
