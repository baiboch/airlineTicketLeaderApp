package com.airlineticketsearcher.app.web.pages;

import com.airlineticketsearcher.app.service.AccessTokenService;
import com.airlineticketsearcher.app.service.FlightInspirationSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @Autowired
  AccessTokenService accessTokenService;

  @Autowired
  FlightInspirationSearchService flightInspirationSearchService;

  @GetMapping("/")
  public String home() {

    accessTokenService.refreshAccessToken();

    return "index";
  }
}
