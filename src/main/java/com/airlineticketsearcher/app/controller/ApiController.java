package com.airlineticketsearcher.app.controller;

import com.airlineticketsearcher.app.model.FlightDestinationsRequest;
import com.airlineticketsearcher.app.service.AccessTokenService;
import com.airlineticketsearcher.app.service.FlightInspirationSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces="application/json")
@RequiredArgsConstructor
public class ApiController {

    private final AccessTokenService tokenService;
    private final FlightInspirationSearchService flightInspirationSearchService;

    @GetMapping("/token")
    public ResponseEntity<String> getToken() {
        String token = tokenService.getAccessToken();
        return ResponseEntity.ok(token);
    }

    @GetMapping("/data")
    public ResponseEntity<String> getData(@RequestParam() String from,
                                          @RequestParam() String maxPrice,
                                          @RequestParam(required = false) String viewBy,
                                          @RequestParam String accessToken) {

        FlightDestinationsRequest flightDestinationsRequest = new FlightDestinationsRequest();
        flightDestinationsRequest.setOrigin(from);
        flightDestinationsRequest.setMaxPrice(maxPrice);
        flightDestinationsRequest.setViewBy(viewBy);
        flightDestinationsRequest.setAccessToken(accessToken);

        String data = flightInspirationSearchService.fetchFlightDestinations(flightDestinationsRequest);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<String> refreshToken() {
        tokenService.refreshAccessToken();
        return ResponseEntity.ok("Token refreshed!");
    }
}
