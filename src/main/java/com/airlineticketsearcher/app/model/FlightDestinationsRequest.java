package com.airlineticketsearcher.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FlightDestinationsRequest extends AccessToken {
    private String origin;
    private String maxPrice;
    private String viewBy;
}
