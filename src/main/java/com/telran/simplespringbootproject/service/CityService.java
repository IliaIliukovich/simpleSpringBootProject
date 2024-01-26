package com.telran.simplespringbootproject.service;

import com.telran.simplespringbootproject.model.City;
import com.telran.simplespringbootproject.model.Country;
import com.telran.simplespringbootproject.repository.CityRepository;
import com.telran.simplespringbootproject.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class CityService {

    private final CityRepository repository;
    private final CountryRepository countryRepository;

    @Autowired
    public CityService(CityRepository repository, CountryRepository countryRepository) {
        this.repository = repository;
        this.countryRepository = countryRepository;
    }

    public List<City> getAllCities() {
        return repository.findAll();
    }

    public List<City> getAllCitiesByCountry(String countryCode) {
        return repository.findCitiesByCountryCode(countryCode);
    }

    //    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Transactional
    public City addSpecialCityAndCountry(String name) {
        Country country = new Country();
        country.setName("New country for " + name);
        country.setCode(name.substring(0, 3));

        Country savedCountry = countryRepository.save(country);

        // В случае выпадения Exception все изменения метода откатятся назад
//        System.out.println(1 / 0);

        City city = new City();
        city.setName(name);
        city.setPopulation(1.0);
        city.setCountry(savedCountry);

        return repository.save(city);
    }

    public City addSpecialCityToCountry(String name) {
        // Пример ленивой загрузки через getReferenceById()
//        Country country = countryRepository.findById("www").get();
        Country country = countryRepository.getReferenceById("www");

        City city = new City();
        city.setName(name);
        city.setPopulation(1.0);
        city.setCountry(country);

        return repository.save(city);
    }

    public void getSpecialCity() {
        // Пример ленивой загрузки классов в отношении @ManyToOne(fetch = FetchType.LAZY)
        City city = repository.findById(1L).get();
        System.out.println(city.getName());
        System.out.println(city.getCountry());
    }
}
