package com.airlineticketsearcher.app.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        String title = "Airline Ticket Searcher";
        model.addAttribute("title", title);

        return "index";
    }
}
