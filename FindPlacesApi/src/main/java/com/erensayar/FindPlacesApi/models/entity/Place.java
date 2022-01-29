package com.erensayar.FindPlacesApi.models.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

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

    // private String isOpen; // TODO : Null pointer problemi

    private Double rating;

    private String address;

    private String type;

    private String searchParamsCoordinateRadius; // for query did repeat control
}