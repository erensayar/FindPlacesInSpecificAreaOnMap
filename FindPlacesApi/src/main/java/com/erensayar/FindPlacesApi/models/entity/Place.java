package com.erensayar.FindPlacesApi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String coordinate;

    private String isOpen;

    private Double rating;

    private String photoReference;

    private String address;

    private String type;

    @JsonIgnore
    private String searchParamsCoordinateRadius; // for query did repeat control
}