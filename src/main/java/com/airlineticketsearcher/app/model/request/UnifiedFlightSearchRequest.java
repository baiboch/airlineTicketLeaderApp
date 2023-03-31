package com.airlineticketsearcher.app.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnifiedFlightSearchRequest {

    private String origin;
    private String maxPrice;
}
