package com.telran.simplespringbootproject.controller;

import com.telran.simplespringbootproject.model.Country;
import com.telran.simplespringbootproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pages")
public class CountryController {

    private final CountryService service;

    @Autowired
    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping // http://localhost:8080/pages
    public String homepage(){
        return "index";
    }

    @GetMapping("/countries") // http://localhost:8080/pages/countries
    public String getAllCountries(Model model){
        List<Country> countries = service.getAllCountries();
        model.addAttribute("countriesForModel", countries);
        return "countries";
    }



}
