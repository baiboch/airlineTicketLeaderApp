package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.AmadeusFlight;
import com.airlineticketsearcher.app.model.request.UnifiedFlightSearchRequest;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightDate;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AmadeusFlightService implements FlightService {

    @Value("${flightTicketResource.amadeus.app_config.api_key}")
    private String apiKey;

    @Value("${flightTicketResource.amadeus.app_config.api_secret}")
    private String apiSecret;

    @Override
    public List<AmadeusFlight> searchFlight(UnifiedFlightSearchRequest request) {
        try {
            Amadeus amadeus = getAmadeusApi();
//            String url = "/v1/shopping/flight-destinations?origin=PAR";

//            FlightDate[] flightDates = amadeus.shopping.flightDates.get(Params
//                .with("origin", "MAD")
//                .and("destination", "MUC"));


            Params flightOffersSearchParameters = Params.with("originLocationCode", "PAR")
                .and("destinationLocationCode", "MAD")
                .and("departureDate", "2024-08-01")
                .and("returnDate", "2024-08-12")
                .and("adults", 1);

            FlightOfferSearch[] flightOfferSearch = amadeus.shopping.flightOffersSearch.get(
                flightOffersSearchParameters);

//            Params recommendedLocationsParams = Params.with("cityCodes", "PAR").and("travelerCountryCode", "FR");
//            Location[] destinations = amadeus.referenceData.recommendedLocations.get(recommendedLocationsParams);

            List<AmadeusFlight> flights = Arrays.stream(flightOfferSearch).map(flightOfferSearchItem -> {
                AmadeusFlight flight = new AmadeusFlight();
                flight.setDestination(flightOfferSearchItem.getSource());
                flight.setType(flightOfferSearchItem.getType());

                return flight;
            }).collect(Collectors.toList());

            return flights;
        } catch (ResponseException e) {
            log.error("Amadeus shopping flightDestinations error {}", e.getMessage());
            return null;
        }
    }

    private Amadeus getAmadeusApi() {
        return Amadeus
            .builder(apiKey, apiSecret)
            .setLogLevel("debug")
            .build();
    }
}
