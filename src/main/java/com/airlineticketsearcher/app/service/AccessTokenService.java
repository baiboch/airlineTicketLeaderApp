package com.airlineticketsearcher.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AccessTokenService {

  @Value("${flightTicketResource.amadeus.app_config.url}")
  private String apiUrl;

  @Value("${flightTicketResource.amadeus.app_config.api_key}")
  private String apiKey;

  @Value("${flightTicketResource.amadeus.app_config.api_secret}")
  private String apiSecret;

  @Value("${flightTicketResource.amadeus.api.get_access_token}")
  private String getAccessTokenEndpoint;

  private final RestTemplate restTemplate;
  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  @Scheduled(fixedRate = 2 * 60 * 1000) // Обновление токена каждые 2 минуты
  public void refreshAccessToken() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    String requestBody = "grant_type=client_credentials&client_id=" +
        apiKey + "&client_secret=" + apiSecret;
    HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
    ResponseEntity<String> response = restTemplate.postForEntity(getAccessTokenRetrieveUrl(), requestEntity, String.class);

    if (response.getStatusCode().is2xxSuccessful()) {
      accessToken = response.getBody(); // Вам может потребоваться распарсить JSON-ответ, чтобы извлечь токен
    } else {
      throw new RuntimeException("Failed to fetch token from external service");
    }
  }

  private String getAccessTokenRetrieveUrl() {
    return apiUrl + getAccessTokenEndpoint;
  }
}
