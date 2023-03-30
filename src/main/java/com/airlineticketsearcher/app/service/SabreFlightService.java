package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.SabreFlight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SabreFlightService implements FlightService {
    @Override
    public SabreFlight searchFlight(String origin, String destination, LocalDate date) {
        return null;
    }
}
