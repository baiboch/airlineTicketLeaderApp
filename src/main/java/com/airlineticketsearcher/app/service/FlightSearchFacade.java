package com.airlineticketsearcher.app.service;

import com.airlineticketsearcher.app.adapter.FlightAdapter;
import com.airlineticketsearcher.app.model.AmadeusFlight;
import com.airlineticketsearcher.app.model.SabreFlight;
import com.airlineticketsearcher.app.model.TravelportFlight;
import com.airlineticketsearcher.app.model.UnifiedFlight;
import com.airlineticketsearcher.app.strategy.AmadeusFlightConversionStrategy;
import com.airlineticketsearcher.app.strategy.SabreFlightConversionStrategy;
import com.airlineticketsearcher.app.strategy.TravelportFlightConversionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightSearchFacade {

    @Autowired
    private AmadeusFlightService amadeusFlightService;

    @Autowired
    private SabreFlightService sabreFlightService;

    @Autowired
    private TravelportFlightService travelportFlightService;

    public List<UnifiedFlight> searchFlights(String origin, String destination, LocalDate date) {
        List<UnifiedFlight> flights = new ArrayList<>();

        AmadeusFlight amadeusFlight = amadeusFlightService.searchFlight(origin, destination, date);
        SabreFlight sabreFlight = sabreFlightService.searchFlight(origin, destination, date);
        TravelportFlight travelportFlight = travelportFlightService.searchFlight(origin, destination, date);

        // Адаптируем и добавляем найденные рейсы в единую коллекцию с использованием стратегий
        flights.add(new FlightAdapter(new AmadeusFlightConversionStrategy()).adapt(amadeusFlight));
        flights.add(new FlightAdapter(new SabreFlightConversionStrategy()).adapt(sabreFlight));
        flights.add(new FlightAdapter(new TravelportFlightConversionStrategy()).adapt(travelportFlight));

        return flights;
    }
}
