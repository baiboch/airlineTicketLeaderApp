package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.TravelportFlight;
import com.airlineticketsearcher.app.model.request.UnifiedFlightSearchRequest;
import org.springframework.stereotype.Service;

@Service
public class TravelportFlightService implements FlightService {

    @Override
    public TravelportFlight searchFlight(UnifiedFlightSearchRequest request) {
        return null;
    }
}
