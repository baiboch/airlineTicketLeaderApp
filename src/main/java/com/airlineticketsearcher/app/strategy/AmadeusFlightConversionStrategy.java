package com.airlineticketsearcher.app.strategy;

import com.airlineticketsearcher.app.model.AmadeusFlight;
import com.airlineticketsearcher.app.model.UnifiedFlight;

public class AmadeusFlightConversionStrategy implements FlightConversionStrategy {

  @Override
  public UnifiedFlight convert(Object systemFlight) {
    AmadeusFlight amadeusFlight = (AmadeusFlight) systemFlight;
    UnifiedFlight unifiedFlight = new UnifiedFlight();


    // Конвертация данных из AmadeusFlight в UnifiedFlight
    return unifiedFlight;
  }
}
