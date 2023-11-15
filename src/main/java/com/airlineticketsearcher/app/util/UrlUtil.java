package com.airlineticketsearcher.app.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@UtilityClass
public class UrlUtil {

  public static String toQueryString(Object object) {
    try {
      return "?" + Stream.of(object.getClass().getDeclaredFields())
          .map(field -> {
            try {
              field.setAccessible(true);
              String key = field.getName();
              Object value = field.get(object);
              if (value != null) {
                return URLEncoder.encode(key, StandardCharsets.UTF_8)
                    + "="
                    + URLEncoder.encode(value.toString(), StandardCharsets.UTF_8);
              }
              return "";
            } catch (IllegalAccessException e) {
              throw new RuntimeException("Error converting object to query string", e);
            }
          })
          .filter(s -> !s.isEmpty())
          .collect(Collectors.joining("&"));
    } catch (Exception e) {
      String error = "Error converting object to query string";
      log.error(error);
      throw new RuntimeException(error, e);
    }
  }
}
