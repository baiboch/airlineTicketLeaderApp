package com.airlineticketsearcher.app.service;

import java.time.LocalDate;

public interface FlightService {

    Object searchFlight(String origin, String destination, LocalDate date);
}
