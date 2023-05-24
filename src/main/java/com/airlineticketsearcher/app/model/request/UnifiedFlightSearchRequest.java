package com.airlineticketsearcher.app.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnifiedFlightSearchRequest {

    private String from;
    private String to;
    private String maxPrice;

    public UnifiedFlightSearchRequest(String from, String maxPrice) {
        this.from = from;
        this.maxPrice = maxPrice;
    }
}
