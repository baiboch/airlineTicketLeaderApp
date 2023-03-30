package com.airlineticketsearcher.app.adapter;

import com.airlineticketsearcher.app.model.UnifiedFlight;
import com.airlineticketsearcher.app.strategy.FlightConversionStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlightAdapter {

    private final FlightConversionStrategy strategy;

    public UnifiedFlight adapt(Object systemFlight) {
        return strategy.convert(systemFlight);
    }
}
