package com.telran.simplespringbootproject.controller.rest;

import com.telran.simplespringbootproject.model.City;
import com.telran.simplespringbootproject.model.Country;
import com.telran.simplespringbootproject.service.CityService;
import com.telran.simplespringbootproject.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
//@Slf4j
public class RestController {

    private static final Logger logger = LogManager.getLogger(RestController.class);

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
        List<Country> countries = service.getAllCountries();

        // old version
//        if (logger.isDebugEnabled()) {
//            logger.debug("Special Countries : {}", countries.stream().filter(country -> country.getName().startsWith("A")).toList());
//        }

        logger.debug("Special Countries : {}", () -> countries.stream().filter(country -> country.getName().startsWith("A")).toList());
        return countries;
    }

    @GetMapping("/country") // http://localhost:8080/rest/country?code=DEU
    public Optional<Country> getCountry(@RequestParam String code){
//        logger.debug("Got request getCountry by " + code); // bad practice
        logger.debug("Got request getCountry by {}", code);
        Optional<Country> countryByCode = service.getCountryByCode(code);
        logger.debug("Retrieved data: {}. Code: {}", countryByCode, code);
        return countryByCode;
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
