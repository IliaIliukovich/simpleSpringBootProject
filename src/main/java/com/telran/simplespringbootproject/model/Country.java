package com.telran.simplespringbootproject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Country {

    @Id
    private String code;

    private String name;

//    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
//    private List<City> cityList;

    // unidirectional --- bidirectional
    // One to One
    // Many to One
    // One to Many
    // Many to Many

}
