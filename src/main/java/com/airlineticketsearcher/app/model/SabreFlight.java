package com.airlineticketsearcher.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SabreFlight {

    private String type;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date returnDate;
}
