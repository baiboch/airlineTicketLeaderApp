package com.airlineticketsearcher.app.service.strategy;

import com.airlineticketsearcher.app.model.TravelportFlight;
import com.airlineticketsearcher.app.model.UnifiedFlight;

public class TravelportFlightConversionStrategy implements FlightConversionStrategy {

    @Override
    public UnifiedFlight convert(Object systemFlight) {
        TravelportFlight travelportFlight = (TravelportFlight) systemFlight;
        UnifiedFlight unifiedFlight = new UnifiedFlight();
        // Конвертация данных из TravelportFlight в UnifiedFlight
        return unifiedFlight;
    }
}
