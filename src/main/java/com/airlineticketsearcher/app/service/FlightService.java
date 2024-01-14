package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.request.UnifiedFlightSearchRequest;

public interface FlightService {

    Object searchFlight(UnifiedFlightSearchRequest request);
}
