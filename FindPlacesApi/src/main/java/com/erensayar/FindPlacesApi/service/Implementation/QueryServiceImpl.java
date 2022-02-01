package com.erensayar.FindPlacesApi.service.Implementation;

import com.erensayar.FindPlacesApi.constant.GooglePlacesApiConstant;
import com.erensayar.FindPlacesApi.error.exception.InternalServerErrorException;
import com.erensayar.FindPlacesApi.error.exception.NoContentException;
import com.erensayar.FindPlacesApi.models.entity.Place;
import com.erensayar.FindPlacesApi.models.response.GooglePlaceApiResponse;
import com.erensayar.FindPlacesApi.models.response.GooglePlaceApiResponse.Result;
import com.erensayar.FindPlacesApi.service.PlaceService;
import com.erensayar.FindPlacesApi.service.QueryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class QueryServiceImpl implements QueryService {

    private final PlaceService placeService;
    private final GooglePlacesApiConstant googlePlacesApiConstant;
    private final ObjectMapper objectMapper;

    @Override
    public List<Place> sendQueryToGooglePlacesApi(Map<String, String> paramMap) {
        String coordinate = paramMap.get("location").replaceAll("\\s", "");
        String radius = paramMap.get("radius");
        String type = paramMap.get("type");

        // This params(coordinate+radius) help me when I'm controlling, query is recurring query?
        String searchParamsCoordinateRadius = coordinate + "-" + radius + "-" + type;

        // If the query has been made before, it returns the registered answer.
        // If not registered method return null and we continue.
        List<Place> placesInDb = placeService.getResponseByCoordinateAndRadius(searchParamsCoordinateRadius);
        if (placesInDb.size() != 0) {
            return placesInDb;
        }

        // Prepare url parameters
        StringBuilder paramsAsString = new StringBuilder();
        for (var p : paramMap.entrySet()) {
            paramsAsString.append("&").append(p.getKey()).append("=").append(p.getValue());
        }

        // Build Url
        String url = googlePlacesApiConstant.getBaseUrl()
                + googlePlacesApiConstant.getServices().getNearbySearch().getUrl()
                + googlePlacesApiConstant.getDataFormat()
                + "?"
                + paramsAsString.substring(1); // start without &

        // Build request
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();

        try {
            // Get response body
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            // Null Check
            if (responseBody == null) throw new NoContentException();

            // Response decoding
            GooglePlaceApiResponse googlePlaceApiResponse = decodeResponse(responseBody);

            // Get Places
            List<Place> places = getPlacesFromResponse(googlePlaceApiResponse, searchParamsCoordinateRadius);

            // Save to db before return
            for (Place place : places) {
                placeService.saveResponse(place);
            }

            return places;
        } catch (IOException e) {
            log.error("Error when send request to google places api" + e.getMessage());
            throw new NoContentException();
        }
    }

    private List<Place> getPlacesFromResponse(GooglePlaceApiResponse googlePlaceApiResponse,
                                              String searchParamsCoordinateRadius) {
        List<Place> places = new ArrayList<>();
        for (Result r : googlePlaceApiResponse.getResults()) {
            String latitude = coordinateSimplifier(String.valueOf(r.getGeometry().getLocation().getLat()));
            String longitude = coordinateSimplifier(String.valueOf(r.getGeometry().getLocation().getLng()));
            String coordinate = latitude + "," + longitude;
            String isOpen = r.getOpeningHours() == null ? null : r.getOpeningHours().getOpenNow();
            String photoReference = r.getPhotos() == null || r.getPhotos().size() == 0 ? null : r.getPhotos().get(0).getPhotoReference();
            String name = r.getName() == null ? null : r.getName();
            Double rating = r.getRating() == null ? null : r.getRating();
            String address = r.getVicinity() == null ? null : r.getVicinity();
            String types = r.getTypes() == null ? null : listToString(r.getTypes());
            Place place = Place.builder()
                    .name(name)
                    .coordinate(coordinate)
                    .rating(rating)
                    .address(address)
                    .searchParamsCoordinateRadius(searchParamsCoordinateRadius)
                    .photoReference(photoReference)
                    .type(types)
                    .isOpen(isOpen)
                    .build();
            places.add(place);
        }
        return places;
    }

    // This method received coordinate make shortener
    private String coordinateSimplifier(String latitudeOrLongitude) {
        if (latitudeOrLongitude.length() > 10) {
            return latitudeOrLongitude.substring(0, 10);
        } else {
            return latitudeOrLongitude;
        }
    }

    private String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(", ");
        }
        return sb.substring(0, sb.toString().length() - 2);
    }

    // Deserialize
    private GooglePlaceApiResponse decodeResponse(ResponseBody responseBody) {
        try {
            return objectMapper.readValue(responseBody.string(), GooglePlaceApiResponse.class);
        } catch (IOException e) {
            log.error("Object Mapping Error");
            throw new InternalServerErrorException("Object Mapping Error: " + e.getMessage());
        }
    }

}
