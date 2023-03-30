package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.TravelportFlight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TravelportFlightService implements FlightService {

    @Override
    public TravelportFlight searchFlight(String origin, String destination, LocalDate date) {
        return null;
    }
}
