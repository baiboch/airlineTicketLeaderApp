package com.airlineticketsearcher.app.model.request;

import com.airlineticketsearcher.app.model.AccessToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AmadeusFlightDestinationsRequest extends AccessToken {

    private String origin;
    private String maxPrice;
}
