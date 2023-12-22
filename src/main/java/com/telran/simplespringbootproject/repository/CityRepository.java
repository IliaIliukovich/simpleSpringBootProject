package com.telran.simplespringbootproject.repository;

import com.telran.simplespringbootproject.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findCitiesByCountryCode(String code);

}
