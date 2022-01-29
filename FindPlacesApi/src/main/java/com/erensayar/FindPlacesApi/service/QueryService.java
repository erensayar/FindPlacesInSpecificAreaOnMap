package com.erensayar.FindPlacesApi.service;

import com.erensayar.FindPlacesApi.models.entity.Place;

import java.util.List;
import java.util.Map;

public interface QueryService {

    List<Place> sendQueryToGooglePlacesApi(Map<String, String> paramMap);

}
