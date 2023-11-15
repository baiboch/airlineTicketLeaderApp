package com.airlineticketsearcher.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnifiedFlight {

    private String type;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
}
