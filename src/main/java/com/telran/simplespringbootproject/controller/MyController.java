package com.telran.simplespringbootproject.controller;

import com.telran.simplespringbootproject.model.City;
import com.telran.simplespringbootproject.model.Country;
import com.telran.simplespringbootproject.service.CityService;
import com.telran.simplespringbootproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
public class MyController {

    @Autowired
    private CountryService service;

    @Autowired
    private CityService cityService;

    @GetMapping
    public String sayHello(){
        return "Hello from my excellent website!";
    }

    @GetMapping("/countries") // http://localhost:8080/app/countries
    public List<Country> getAllCountries(){
        return service.getAllCountries();
    }

    @GetMapping("/country") // http://localhost:8080/app/country?code=DEU
    public Optional<Country> getCountry(@RequestParam String code){
        return service.getCountryByCode(code);
    }

    @GetMapping("/search") // http://localhost:8080/app/search?code=D
    public List<Country> getCountryByCode(@RequestParam String code){
        return service.findCountriesByCodeStartingWith(code);
    }

    @GetMapping("/georgia") // http://localhost:8080/app/georgia
    public Optional<Country> getGeorgia(){
        return service.findGeorgia();
    }

    @GetMapping("/cities") // http://localhost:8080/app/cities
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/citiesByCountry") // http://localhost:8080/app/citiesByCountry?countryCode=AFG
    public List<City> getAllCities(@RequestParam String countryCode){
        return cityService.getAllCitiesByCountry(countryCode);
    }

    @PostMapping("/addcountry") // http://localhost:8080/app/addcountry
    public void addCountry(@RequestBody Country country){
        System.out.println("Saving new country: " + country);
        service.saveCounty(country);
    }

    @GetMapping("/update") // http://localhost:8080/app/update
    public void updateAfghanistan(){
        System.out.println("Updating Afghanistan with hardcoded values");
        service.updateAfghanistan();
    }



}
