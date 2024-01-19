package com.telran.simplespringbootproject.service;

import com.telran.simplespringbootproject.model.City;
import com.telran.simplespringbootproject.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getAllCities() {
        return repository.findAll();
    }

    public List<City> getAllCitiesByCountry(String countryCode) {
        return repository.findCitiesByCountryCode(countryCode);
    }
}
