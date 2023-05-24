package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.UnifiedFlight;
import com.airlineticketsearcher.app.model.request.UnifiedFlightSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightSearchService {

  private final FlightSearchFacade flightSearchFacade;

  public List<UnifiedFlight> searchFlights(UnifiedFlightSearchRequest request) {
    return flightSearchFacade.searchFlights(request);
  }
}
