package com.erensayar.FindPlacesApi.controller;

import com.erensayar.FindPlacesApi.service.QueryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value = "Query API Documentation")
@RequestMapping("/api/v1/query/google-places")
@RequiredArgsConstructor
@RestController
public class QueryController {

    private final QueryService queryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendQueryToGooglePlacesApi(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(queryService.sendQueryToGooglePlacesApi(params), HttpStatus.OK);
    }

}
