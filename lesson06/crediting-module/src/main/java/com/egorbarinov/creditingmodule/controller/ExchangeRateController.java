package com.egorbarinov.creditingmodule.controller;

import com.egorbarinov.creditingmodule.service.ExchangeRateService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) throws IOException {
        this.exchangeRateService = exchangeRateService;
        exchangeRateService.processingHttpRequest();
    }

    @InitBinder   // для web обработки сообщений. WebDataBinder блокирует нулевые формы
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping({"/","/index"})
    public String index(Model model, @RequestParam(required = false, name = "date_req") String date_req) {

        model.addAttribute("currencies", exchangeRateService.getAll());

        return "index";
    }

}
