package com.telran.simplespringbootproject.service;

import com.telran.simplespringbootproject.model.City;
import com.telran.simplespringbootproject.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;
    public List<City> getAllCities() {
        return repository.findAll();
    }

    public List<City> getAllCitiesByCountry(String countryCode) {
        return repository.findCitiesByCountryCode(countryCode);
    }
}
