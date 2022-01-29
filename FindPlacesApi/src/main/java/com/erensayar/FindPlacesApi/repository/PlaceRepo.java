package com.erensayar.FindPlacesApi.repository;

import com.erensayar.FindPlacesApi.models.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepo extends JpaRepository<Place, Long> {

    //@Query(value = "select p from Place p where p.coordinate = ?1 and p.radius = ?2")
    //List<Place> findAllByCoordinateAndRadius(String coordinate, Integer radius);

    List<Place> findAllBySearchParamsCoordinateRadius(String searchParamsCoordinateRadius);


}
