package com.telran.simplespringbootproject.service;

import com.telran.simplespringbootproject.model.Country;
import com.telran.simplespringbootproject.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getAllCountries(){
       return repository.findAll();
    }

    public Optional<Country> getCountryByCode(String code){
        return repository.findById(code);
    }

    // Пример: два вызова findById() приведут только к одному запросу в БД
//    public Optional<Country> getCountryByCode(String code){
//        return repository.findById(code);
//        Optional<Country> country = repository.findById(code);
//        System.out.println(country);
//        country = repository.findById(code);
//        System.out.println(country);
//        return country;
//    }

    public List<Country> findCountriesByCodeStartingWith(String code) {
        return repository.findCountriesByCodeStartingWith(code);
    }

    public Optional<Country> findGeorgia(){
        return repository.custom();
    }

    public void saveCounty(Country country) {
        repository.save(country);
    }

    public void updateAfghanistan(){
        Country country = repository.findById("AFG").get();
        country.setName("Afghanistan New Name");
        repository.save(country);
    }
}
