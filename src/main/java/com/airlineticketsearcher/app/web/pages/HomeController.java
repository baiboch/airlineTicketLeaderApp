package com.airlineticketsearcher.app.web.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    System.out.println("Hello");

    String message = "Hello, World!";
    model.addAttribute("message", message);
    return "index";
  }
}
