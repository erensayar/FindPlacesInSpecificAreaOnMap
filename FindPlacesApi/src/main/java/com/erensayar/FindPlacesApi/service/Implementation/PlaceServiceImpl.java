package com.erensayar.FindPlacesApi.service.Implementation;

import com.erensayar.FindPlacesApi.models.entity.Place;
import com.erensayar.FindPlacesApi.repository.PlaceRepo;
import com.erensayar.FindPlacesApi.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepo placeRepo;

    @Override
    public Place saveResponse(Place place) {
        return placeRepo.save(place);
    }

    @Override
    public List<Place> getResponseByCoordinateAndRadius(String searchParamsCoordinateRadius) {
        List<Place> places = placeRepo.findAllBySearchParamsCoordinateRadius(searchParamsCoordinateRadius);
        if (places.isEmpty())
            return new ArrayList<Place>();
        return places;
    }
}

