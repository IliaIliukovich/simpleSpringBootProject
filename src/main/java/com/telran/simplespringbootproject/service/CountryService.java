package com.telran.simplespringbootproject.service;

import com.telran.simplespringbootproject.model.Country;
import com.telran.simplespringbootproject.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> getAllCountries(){
       return repository.findAll();
    }

    public Optional<Country> getCountryByCode(String code){
        return repository.findById(code);
    }

    public List<Country> findCountriesByCodeStartingWith(String code) {
        return repository.findCountriesByCodeStartingWith(code);
    }

    public Optional<Country> findGeorgia(){
        return repository.custom();
    }

}
