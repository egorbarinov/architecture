package com.egorbarinov.creditingmodule.controller;

import com.egorbarinov.creditingmodule.service.ExchangeRateService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) throws IOException {
        this.exchangeRateService = exchangeRateService;
        exchangeRateService.processingHttpRequest();
    }

    @GetMapping({"/","/index"})
    public String index(Model model) {

        model.addAttribute("currencies", exchangeRateService.getAll());

        return "index";
    }

}
