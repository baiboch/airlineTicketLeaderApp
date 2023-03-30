package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.model.AmadeusFlight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AmadeusFlightService implements FlightService {

    @Override
    public AmadeusFlight searchFlight(String origin, String destination, LocalDate date) {
        return null;
    }
}
