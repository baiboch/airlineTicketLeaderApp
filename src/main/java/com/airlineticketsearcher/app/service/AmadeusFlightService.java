package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.AmadeusFlight;
import com.airlineticketsearcher.app.model.request.UnifiedFlightSearchRequest;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AmadeusFlightService implements FlightService {

  @Value("${tickerSearcher.amadeus.app.api_key}")
  private String apiKey;

  @Value("${tickerSearcher.amadeus.app.api_secret}")
  private String apiSecret;

  @Override
  public List<AmadeusFlight> searchFlight(UnifiedFlightSearchRequest request) {

    Amadeus amadeus = Amadeus
        .builder(apiKey, apiSecret)
        .setLogLevel("debug")
        .build();

    try {
      String url = "/v1/shopping/flight-destinations?origin=PAR";

      // JsonObject flightDestinations = amadeus.get(url, Params.with("originLocationCode", "PAR")).getResult();

      Location[] destinations = amadeus.referenceData.recommendedLocations.get(Params
          .with("cityCodes", "PAR")
          .and("travelerCountryCode", "FR"));

//            List<AmadeusFlight> flights = Arrays.stream(flightDestinations).map(flightDestination -> new AmadeusFlight(
//                    flightDestination.getType(),
//                    flightDestination.getOrigin(),
//                    flightDestination.getDestination(),
//                    flightDestination.getDepartureDate(),
//                    flightDestination.getReturnDate(),
//                    flightDestination.getPrice()
//            )).collect(Collectors.toList());

      return null;
    } catch (ResponseException e) {
      log.error("Amadeus shopping flightDestinations error {}", e.getMessage());
      return null;
    }
  }
}
