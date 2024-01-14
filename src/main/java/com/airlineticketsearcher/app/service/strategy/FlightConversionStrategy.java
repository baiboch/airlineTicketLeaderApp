package com.airlineticketsearcher.app.service.strategy;

import com.airlineticketsearcher.app.model.UnifiedFlight;

@FunctionalInterface
public interface FlightConversionStrategy {
    UnifiedFlight convert(Object systemFlight);
}
