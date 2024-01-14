package com.airlineticketsearcher.app.model;

import com.amadeus.resources.FlightDestination;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AmadeusFlight {

    private String type;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
    private FlightDestination.Price price;
}
