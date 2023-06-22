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
@RequestMapping(path = "/api", produces="application/json")
@RequiredArgsConstructor
public class ApiController {

    private final FlightSearchService flightSearchService;

    public ResponseEntity<String> getDirections(@RequestParam() String from, @RequestParam() String to) {
        List<UnifiedFlight> flightList = flightSearchService.searchFlights(new UnifiedFlightSearchRequest(from, to));
        return ResponseEntity.ok(flightList.toString());
    }

    @GetMapping("/data-to")
    public ResponseEntity<String> getDirections(@RequestParam() String from, @RequestParam() String to, @RequestParam() String maxPrice) {
        List<UnifiedFlight> flightList = flightSearchService.searchFlights(new UnifiedFlightSearchRequest(from, to, maxPrice));
        return ResponseEntity.ok(flightList.toString());
    }
}
