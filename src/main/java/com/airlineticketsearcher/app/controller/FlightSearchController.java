package com.airlineticketsearcher.app.controller;

import com.airlineticketsearcher.app.model.UnifiedFlight;
import com.airlineticketsearcher.app.model.request.UnifiedFlightSearchRequest;
import com.airlineticketsearcher.app.service.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${app_config.api_path}/search-flight")
@RequiredArgsConstructor
public class FlightSearchController {

    private final FlightSearchService flightSearchService;

    @GetMapping(
          value = "/",
          consumes = "application/json",
          produces = "application/json"
    )
    public ResponseEntity<String> getDirections(
          @RequestParam(name = "from") String from,
          @RequestParam(name = "to", required = false) String to,
          @RequestParam(name = "maxPrice", required = false) String maxPrice) {

        List<UnifiedFlight> flightList = flightSearchService.searchFlights(
              new UnifiedFlightSearchRequest(from, to, maxPrice)
        );
        return ResponseEntity.ok(flightList.toString());
    }
}
