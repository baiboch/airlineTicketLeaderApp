package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.SabreFlight;
import com.airlineticketsearcher.app.model.request.UnifiedFlightSearchRequest;
import org.springframework.stereotype.Service;

@Service
public class SabreFlightService implements FlightService {

    @Override
    public SabreFlight searchFlight(UnifiedFlightSearchRequest request) {
        return null;
    }
}
