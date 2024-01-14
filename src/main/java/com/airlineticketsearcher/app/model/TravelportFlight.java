package com.airlineticketsearcher.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TravelportFlight {

    private String type;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
}
