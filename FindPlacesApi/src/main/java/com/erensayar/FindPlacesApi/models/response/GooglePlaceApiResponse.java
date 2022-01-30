package com.erensayar.FindPlacesApi.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class GooglePlaceApiResponse {

    @Setter(onMethod_ = {@JsonProperty("html_attributions")})
    private List<Object> htmlAttributions;

    @Setter(onMethod_ = {@JsonProperty("next_page_token")})
    private String nextPageToken;

    @Setter(onMethod_ = {@JsonProperty("results")})
    private List<Result> results;

    @Setter(onMethod_ = {@JsonProperty("status")})
    private String status;

    @Data
    public static class Result {

        @Setter(onMethod_ = {@JsonProperty("geometry")})
        private Geometry geometry;

        @Setter(onMethod_ = {@JsonProperty("name")})
        private String name;

        @Setter(onMethod_ = {@JsonProperty("opening_hours")})
        private OpeningHours openingHours;

        @Setter(onMethod_ = {@JsonProperty("rating")})
        private Double rating;

        @Setter(onMethod_ = {@JsonProperty("vicinity")})
        private String vicinity;

        @Setter(onMethod_ = {@JsonProperty("types")})
        private List<String> types;

        @Setter(onMethod_ = {@JsonProperty("photos")})
        private List<Photo> photos;

        @Data
        public static class Photo {

            @Setter(onMethod_ = {@JsonProperty("photo_reference")})
            private String photoReference;
        }

        @Data
        public static class Geometry {

            @Setter(onMethod_ = {@JsonProperty("location")})
            private Location location;

            @Data
            public static class Location {

                @Setter(onMethod_ = {@JsonProperty("lat")})
                private Double lat;

                @Setter(onMethod_ = {@JsonProperty("lng")})
                private Double lng;
            }
        }

        @Data
        public static class OpeningHours {

            @Setter(onMethod_ = {@JsonProperty("open_now")})
            private String openNow;
        }

    }
}