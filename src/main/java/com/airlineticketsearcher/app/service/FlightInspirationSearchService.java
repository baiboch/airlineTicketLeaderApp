package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.exception.AccessTokenException;
import com.airlineticketsearcher.app.model.request.AmadeusFlightDestinationsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.airlineticketsearcher.app.util.UrlUtil.toQueryString;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightInspirationSearchService {

    @Value("${flightTicketResource.amadeus.app_config.url}")
    private String apiUrl;

    @Value("${flightTicketResource.amadeus.api.shopping_flight_destinations}")
    private String shoppingFlightDestinationsEndpoint;

    private final RestTemplate restTemplate;

    public String fetchFlightDestinations(AmadeusFlightDestinationsRequest amadeusFlightDestinationsRequest) {
        String url = apiUrl + shoppingFlightDestinationsEndpoint + toQueryString(amadeusFlightDestinationsRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + amadeusFlightDestinationsRequest.getAccessToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            throw new AccessTokenException("access token expired");
        } else {
            String errorMessage = "Failed to fetch data from external service";
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }
}
