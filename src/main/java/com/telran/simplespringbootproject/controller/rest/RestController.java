package com.telran.simplespringbootproject.controller.rest;

import com.telran.simplespringbootproject.model.City;
import com.telran.simplespringbootproject.model.Country;
import com.telran.simplespringbootproject.service.CityService;
import com.telran.simplespringbootproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    private final CountryService service;

    private final CityService cityService;

    @Autowired
    public RestController(CountryService service, CityService cityService) {
        this.service = service;
        this.cityService = cityService;
    }

    @GetMapping
    public String sayHello(){
        return "Hello from my excellent website!";
    }

//    @GetMapping("/countries") // http://localhost:8080/rest/countries
    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List<Country> getAllCountries(){
        return service.getAllCountries();
    }

    @GetMapping("/country") // http://localhost:8080/rest/country?code=DEU
    public Optional<Country> getCountry(@RequestParam String code){
        return service.getCountryByCode(code);
    }

    @GetMapping("/search") // http://localhost:8080/rest/search?code=D
    public List<Country> getCountryByCode(@RequestParam String code){
        return service.findCountriesByCodeStartingWith(code);
    }

    @GetMapping("/georgia") // http://localhost:8080/rest/georgia
    public Optional<Country> getGeorgia(){
        return service.findGeorgia();
    }

    @GetMapping("/cities") // http://localhost:8080/rest/cities
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/citiesByCountry") // http://localhost:8080/rest/citiesByCountry?countryCode=AFG
    public List<City> getAllCities(@RequestParam String countryCode){
        return cityService.getAllCitiesByCountry(countryCode);
    }

    @PostMapping("/addcountry") // http://localhost:8080/rest/addcountry
    public void addCountry(@RequestBody Country country){
        System.out.println("Saving new country: " + country);
        service.saveCounty(country);
    }

    @GetMapping("/update") // http://localhost:8080/rest/update
    public void updateAfghanistan(){
        System.out.println("Updating Afghanistan with hardcoded values");
        service.updateAfghanistan();
    }

    @GetMapping("/addSpecialCityAndCountry") // http://localhost:8080/rest/addSpecialCityAndCountry?name=ww1
    public City addSpecialCityAndCountry(@RequestParam String name) {
        return cityService.addSpecialCityAndCountry(name);
    }

    @GetMapping("/addSpecialCityToCountry") // http://localhost:8080/rest/addSpecialCityToCountry?name=NewInternetCity
    public City addSpecialCityToCountry(@RequestParam String name) {
        return cityService.addSpecialCityToCountry(name);
    }

    @GetMapping("/getSpecialCity") // http://localhost:8080/rest/getSpecialCity
    public void getSpecialCity() {
        cityService.getSpecialCity();
    }



}
