package com.erensayar.FindPlacesApi.service;

import com.erensayar.FindPlacesApi.models.entity.Place;

import java.util.List;

public interface PlaceService {

    Place saveResponse(Place place);

    List<Place> getResponseByCoordinateAndRadius(String searchParamsCoordinateRadius);

}
