package com.airlineticketsearcher.app.service.strategy;

import com.airlineticketsearcher.app.model.SabreFlight;
import com.airlineticketsearcher.app.model.UnifiedFlight;

public class SabreFlightConversionStrategy implements FlightConversionStrategy {

    @Override
    public UnifiedFlight convert(Object systemFlight) {
        SabreFlight sabreFlight = (SabreFlight) systemFlight;
        UnifiedFlight unifiedFlight = new UnifiedFlight();
        // Конвертация данных из SabreFlight в UnifiedFlight
        return unifiedFlight;
    }
}
