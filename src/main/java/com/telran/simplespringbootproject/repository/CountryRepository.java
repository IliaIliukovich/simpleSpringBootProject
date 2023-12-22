package com.telran.simplespringbootproject.repository;


import com.telran.simplespringbootproject.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

        List<Country> findCountriesByCodeStartingWith (String code);

        @Query("select e from Country e where e.name = 'Georgia'")
        Optional<Country> custom();

}
